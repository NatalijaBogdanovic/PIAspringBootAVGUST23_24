package com.example.backend;

public class Igre {
    private String naziv;
    private String trenutno_pridruzeni;
    private int min;
    private int max;
    private String status ;
    public Igre(String naziv, String trenutno_pridruzeni, int min, int max, String status) {
        this.naziv = naziv;
        this.trenutno_pridruzeni = trenutno_pridruzeni;
        this.min = min;
        this.max = max;
        this.status = status;
    }
    public String getNaziv() {
        return naziv;
    }
    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }
    public String getTrenutno_pridruzeni() {
        return trenutno_pridruzeni;
    }
    public void setTrenutno_pridruzeni(String trenutno_pridruzeni) {
        this.trenutno_pridruzeni = trenutno_pridruzeni;
    }
    public int getMin() {
        return min;
    }
    public void setMin(int min) {
        this.min = min;
    }
    public int getMax() {
        return max;
    }
    public void setMax(int max) {
        this.max = max;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    
    
}
