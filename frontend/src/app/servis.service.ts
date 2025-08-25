import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { Igre } from './models/igre';
import { Korisnik } from './models/korisnik';
import { Poruke } from './models/poruke';

@Injectable({
  providedIn: 'root'
})
export class ServisService {

  constructor() { }
  private http = inject(HttpClient)
  private backendUrl = "http://localhost:8080";

  login(k: Korisnik) {
    return this.http.post<Korisnik>(`${this.backendUrl}/login`, k);
  }
  dohvOtvoreneIgre() {
    return this.http.get<Igre[]>(`${this.backendUrl}/igre`);
  }
  dohvSveIgre() {
    return this.http.get<Igre[]>(`${this.backendUrl}/igreSve`);

  }
  pridruziSe(igrac: Korisnik, naziv: String ) {
    return this.http.post<Igre>(`${this.backendUrl}/pridruzise`, {igrac, naziv})
  }

  prikaziPoruke(ulogovani: String, izabrani:String){
    return this.http.post<Poruke[]>(`${this.backendUrl}/prikaziPoruke`, {ulogovani, izabrani})
  }

  posaljiPoruku(tekst: String, igra: String, izabrani: String, ulogovani: String){
    return this.http.post(`${this.backendUrl}/posaljiPoruku`, {tekst, igra, izabrani, ulogovani})

  }
  promeniStatus(naziv: String) {
    return this.http.post(`${this.backendUrl}/promeniStatus`, naziv);
  }
  resetujIgru(naziv: string) {
    return this.http.post(`${this.backendUrl}/resetujIgru`, naziv);  }

  dodajIgru(igra: Igre){
    return this.http.post(`${this.backendUrl}/dodajIgru`, igra)
  }

}
