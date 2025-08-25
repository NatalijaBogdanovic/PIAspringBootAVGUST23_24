package com.example.backend;

public class PrikazPorZaIgraca {
    private String ulogovani;
    private String izabrani;
    public PrikazPorZaIgraca(String ulogovani, String izabrani) {
        this.ulogovani = ulogovani;
        this.izabrani = izabrani;
    }
    public String getUlogovani() {
        return ulogovani;
    }
    public void setUlogovani(String ulogovani) {
        this.ulogovani = ulogovani;
    }
    public String getIzabrani() {
        return izabrani;
    }
    public void setIzabrani(String izabrani) {
        this.izabrani = izabrani;
    }
    
    
}
