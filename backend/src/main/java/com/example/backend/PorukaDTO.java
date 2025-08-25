package com.example.backend;

public class PorukaDTO {
    private String tekst;
    private String igra;
    private String izabrani;
    private String ulogovani;
    public PorukaDTO(String tekst, String igra, String izabrani, String ulogovani) {
        this.tekst = tekst;
        this.igra = igra;
        this.izabrani = izabrani;
        this.ulogovani = ulogovani;
    }
    public String getTekst() {
        return tekst;
    }
    public void setTekst(String tekst) {
        this.tekst = tekst;
    }
    public String getIgra() {
        return igra;
    }
    public void setIgra(String igra) {
        this.igra = igra;
    }
    public String getIzabrani() {
        return izabrani;
    }
    public void setIzabrani(String izabrani) {
        this.izabrani = izabrani;
    }
    public String getUlogovani() {
        return ulogovani;
    }
    public void setUlogovani(String ulogovani) {
        this.ulogovani = ulogovani;
    }

    
    
}
