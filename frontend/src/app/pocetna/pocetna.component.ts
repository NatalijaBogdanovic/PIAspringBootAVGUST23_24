import { Component, inject } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Korisnik } from '../models/korisnik';
import { ServisService } from '../servis.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-pocetna',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './pocetna.component.html',
  styleUrl: './pocetna.component.css'
})
export class PocetnaComponent {
  username=""
  password=""
  tip=""
  poruka=""
  korisnik=new Korisnik()
  private servis=inject(ServisService)
  private router=inject(Router)

  login(){
    if(this.username.length==0 || this.password.length==0 || this.tip.length==0){
      this.poruka="niste uneli sve podatke"
    }
    else{
      this.poruka=""
      this.korisnik.kor_ime=this.username
      this.korisnik.lozinka=this.password
      this.korisnik.tip=this.tip
      this.servis.login(this.korisnik).subscribe(data=>{
        if(data){
          localStorage.setItem("ulogovan", JSON.stringify(data));
          if(data.tip=="admin"){
            this.router.navigate(['admin'])
          }else{
            this.router.navigate(['igrac'])
          }
        }
        else{
          this.poruka="nepostojeci korisnik"
        }
      })

    }

  }

}
