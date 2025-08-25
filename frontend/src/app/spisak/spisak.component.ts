import { Component, inject, OnInit } from '@angular/core';
import { ActivatedRoute, RouterModule } from '@angular/router';
import { Korisnik } from '../models/korisnik';
import { CommonModule, NgForOf } from "../../../node_modules/@angular/common/index";
import { ServisService } from '../servis.service';
import { Poruke } from '../models/poruke';
import { FormsModule } from '@angular/forms';
import { Location } from '@angular/common';
@Component({
  selector: 'app-spisak',
  standalone: true,
  imports: [FormsModule, RouterModule],
  templateUrl: './spisak.component.html',
  styleUrl: './spisak.component.css'
})
export class SpisakComponent implements OnInit {
  constructor(private location: Location){}

  private ruta= inject(ActivatedRoute)
  private servis= inject(ServisService)
  igraciSaSpiska: string[]=[]
  tekstPoruke=""
  izabraniIgrac=""
  ime=""
  igre=""
  igrac=new Korisnik()
  poruke: Poruke[]=[]
  ngOnInit(): void {
    let i= localStorage.getItem("igre")
    if(i){
      this.igre= JSON.parse(i).naziv
      console.log(this.igre)
    }
    let igraci= this.ruta.snapshot.paramMap.get("spisak")
    if(igraci){
      this.igraciSaSpiska=igraci.split(',');

    }
    this.izaberiIgraca(this.ime);
  }

  izaberiIgraca(ime: string){
    this.izabraniIgrac=ime;
    this.igrac=JSON.parse(localStorage.getItem("ulogovan")!)
    this.servis.prikaziPoruke(this.igrac.kor_ime, this.izabraniIgrac).subscribe(data=>{
      console.log(data)
      if(data){

        this.poruke=data;
        alert("evo puruka")
       // window.location.reload()

      }else{
        alert("nema poruka sa tim igracem")
      }


    })

  }

  nazad(){
    this.location.back();
  }

  posalji(){

    console.log(this.igre)
    this.servis.posaljiPoruku(this.tekstPoruke, this.igre, this.izabraniIgrac, this.igrac.kor_ime).subscribe(data=>{
      if(data){
        this.servis.prikaziPoruke(this.igrac.kor_ime, this.izabraniIgrac).subscribe(data=>{
          if(data){
            window.location.reload();

          }

        })
      }
    })

  }



}
