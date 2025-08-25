import { Component, inject, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Igre } from '../models/igre';
import { Korisnik } from '../models/korisnik';
import { ServisService } from '../servis.service';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-admin',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './admin.component.html',
  styleUrl: './admin.component.css'
})
export class AdminComponent implements OnInit {
  private router = inject(Router)
  private servis = inject(ServisService)
  igrac = new Korisnik()
  igre: Igre[] = []
  nazivNove=""
  minBroj=""
  maxBroj=""
  poruka=""

  ngOnInit(): void {
    this.servis.dohvSveIgre().subscribe(data => {
      this.igre = data;
    })
  }

  odjaviSe() {
    this.router.navigate([''])
    localStorage.removeItem("ulogovan")
  }
  zapocni(naziv: string){
    this.servis.promeniStatus(naziv).subscribe(data=>{
      console.log("uspesno je promenjen status")
      this.ngOnInit();
    })

  }
  zavrsi(naziv: string){
    this.servis.resetujIgru(naziv).subscribe(data=>{
      console.log("uspesno resetovana igra")
      this.ngOnInit();
    })

  }

  potvrdi(){
    let bto=0;
    if(this.nazivNove.length==0 || this.minBroj.length==0 || this.maxBroj.length==0){
      this.poruka="Niste uneli sve podatke"
    }
    for(let i of this.igre){
      if(this.nazivNove==i.naziv){
        this.poruka="Igra sa ovim nazivom vec postoji"
        bto=1;
      }
    }
    const min = Number(this.minBroj);
    const max = Number(this.maxBroj);

    if (isNaN(min) || isNaN(max)) {
      this.poruka="Unesite ispravan broj u polja za min i max igrača!";
      return;
    }

    if (min <= 0 || max <= 0) {
      this.poruka="Broj igrača mora biti pozitivan!";
      return;
    }else if (min > max) {
      this.poruka="Minimalan broj igrača ne može biti veći od maksimalnog!";
      return;
    }
    else{
      this.poruka=""
    }

    if(bto==0){
       let igra=new Igre()
    igra.naziv=this.nazivNove;
    igra.trenutno_pridruzeni="";
    igra.min=min;
    igra.max=max;
    igra.status="otvorena";


    this.servis.dodajIgru(igra).subscribe(data=>{
        console.log("uspesno dodata igra")
        this.ngOnInit();
    })

    }else{
      this.poruka="Igra sa nazivom koji ste uneli vec postoji"
    }




  }


}
