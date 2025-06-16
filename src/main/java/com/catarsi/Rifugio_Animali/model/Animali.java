package com.catarsi.Rifugio_Animali.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity

public class Animali {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id_animale; 
    private String specie;
    private Date data_arrivo;
    private Date data_adozione;
    private String razza;
    private double peso;
    private int eta;
    private String taglia;
    private String colore;
    private String segni_particolari;
    
    public int getId_animale() {
        return id_animale;
    }
    public void setId_animale(int id_animale) {
        this.id_animale = id_animale;
    }
    public String getSpecie() {
        return specie;
    }
    public void setSpecie(String specie) {
        this.specie = specie;
    }
    public Date getData_arrivo() {
        return data_arrivo;
    }
    public void setData_arrivo(Date data_arrivo) {
        this.data_arrivo = data_arrivo;
    }
    public Date getData_adozione() {
        return data_adozione;
    }
    public void setData_adozione(Date data_adozione) {
        this.data_adozione = data_adozione;
    }
    public String getRazza() {
        return razza;
    }
    public void setRazza(String razza) {
        this.razza = razza;
    }
    public double getPeso() {
        return peso;
    }
    public void setPeso(double peso) {
        this.peso = peso;
    }
    public int getEta() {
        return eta;
    }
    public void setEta(int eta) {
        this.eta = eta;
    }
    public String getTaglia() {
        return taglia;
    }
    public void setTaglia(String taglia) {
        this.taglia = taglia;
    }
    public String getColore() {
        return colore;
    }
    public void setColore(String colore) {
        this.colore = colore;
    }
    public String getSegni_particolari() {
        return segni_particolari;
    }
    public void setSegni_particolari(String segni_particolari) {
        this.segni_particolari = segni_particolari;
    } 

    
}
