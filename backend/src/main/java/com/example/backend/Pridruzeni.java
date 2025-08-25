package com.example.backend;

public class Pridruzeni {
    private Korisnik igrac;
    private String naziv;
    public Pridruzeni(Korisnik igrac, String naziv) {
        this.igrac = igrac;
        this.naziv = naziv;
    }
    public Korisnik getIgrac() {
        return igrac;
    }
    public void setIgrac(Korisnik igrac) {
        this.igrac = igrac;
    }
    public String getNaziv() {
        return naziv;
    }
    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }
    
    
}
