import { Component, inject, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Korisnik } from '../models/korisnik';
import { Igre } from '../models/igre';
import { ServisService } from '../servis.service';

@Component({
  selector: 'app-igrac',
  standalone: true,
  imports: [],
  templateUrl: './igrac.component.html',
  styleUrl: './igrac.component.css'
})
export class IgracComponent implements OnInit{
   private router= inject(Router)
   private servis= inject(ServisService)
   igrac= new Korisnik()
   igre: Igre[]=[]

  ngOnInit(): void {
    this.igrac=JSON.parse(localStorage.getItem("ulogovan")!)
    console.log(this.igrac)
    this.servis.dohvOtvoreneIgre().subscribe(data=>{
      this.igre=data;
      let nepozeljni: String[]=[]
      for(let l of data){
        let nizPrijavljenih= l.trenutno_pridruzeni.split(',')
        if(this.igrac.kor_ime in nizPrijavljenih){
          nepozeljni.push(l.naziv);



        }

      }
    })


  }
  pridruziSe(i: Igre){
    localStorage.setItem("igra", JSON.stringify(i));

    this.servis.pridruziSe(this.igrac, i.naziv).subscribe(data=>{
      if(data){
        this.router.navigate(['spisak', {spisak: data.trenutno_pridruzeni}]);
      }
    })


  }

    odjaviSe(){
      this.router.navigate([''])
      localStorage.removeItem("ulogovan")

    }

}
