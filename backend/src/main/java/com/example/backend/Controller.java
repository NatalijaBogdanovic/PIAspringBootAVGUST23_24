package com.example.backend;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;




@RestController
@RequestMapping
@CrossOrigin(origins = "http://localhost:4200/")
public class Controller {

    @PostMapping("/login")
    public Korisnik login(@RequestBody Korisnik k) {
        //TODO: process POST request
        
        return new Repo().login(k);
    }
    @GetMapping("/igre")
    public List<Igre> dohvSlIgre() {
        return new Repo().dohvOtvoreneIgre();
    }
    @GetMapping("/igreSve")
    public List<Igre> dohvSveIgre() {
        return new Repo().dohvSveIgre();
    }
    @PostMapping("/pridruzise")
    public Igre pridruziSeIgri(@RequestBody Pridruzeni p) {
        //TODO: process POST request
        
        return new Repo().pridruziseIgri(p.getIgrac(), p.getNaziv());
    }

    @PostMapping("/prikaziPoruke")
    public List<Poruke> prikaziPoruke(@RequestBody PrikazPorZaIgraca p) {
        //TODO: process POST request
        
        return new Repo().prikaziPoruke(p.getUlogovani(), p.getIzabrani());
    }
    
    @PostMapping("/posaljiPoruku")
    public void dodajPoruku(@RequestBody PorukaDTO p) {
        new Repo().dodajPoruku(p.getTekst(), p.getIgra(), p.getIzabrani(), p.getUlogovani());
        
    }

    @PostMapping("/promeniStatus")
    public void promeniStatus(@RequestBody String naziv) {
        new Repo().promeniStatus(naziv);
    }
    @PostMapping("/resetujIgru")
    public void resetujIgru(@RequestBody String naziv) {
        new Repo().resetujIgru(naziv);
    }
    @PostMapping("/dodajIgru")
    public void dodajIgru(@RequestBody Igre i) {
        //TODO: process POST request
        new Repo().dodajIgru(i);
    }
    
    
    
    
    
    
}
