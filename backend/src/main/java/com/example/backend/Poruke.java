package com.example.backend;

public class Poruke {
    private int idP;
    private String igra ;
    private String igrac1 ;
    private String igrac2 ;
    private String tekst ;
    public Poruke(int idP, String igra, String igrac1, String igrac2, String tekst) {
        this.idP = idP;
        this.igra = igra;
        this.igrac1 = igrac1;
        this.igrac2 = igrac2;
        this.tekst = tekst;
    }
    public int getIdP() {
        return idP;
    }
    public void setIdP(int idP) {
        this.idP = idP;
    }
    public String getIgra() {
        return igra;
    }
    public void setIgra(String igra) {
        this.igra = igra;
    }
    public String getIgrac1() {
        return igrac1;
    }
    public void setIgrac1(String igrac1) {
        this.igrac1 = igrac1;
    }
    public String getIgrac2() {
        return igrac2;
    }
    public void setIgrac2(String igrac2) {
        this.igrac2 = igrac2;
    }
    public String getTekst() {
        return tekst;
    }
    public void setTekst(String tekst) {
        this.tekst = tekst;
    }
    
    
}
