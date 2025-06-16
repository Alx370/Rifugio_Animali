package com.catarsi.Rifugio_Animali.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Donazione {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id_donazione;

    @ManyToOne
    @JoinColumn(name="Utente")
    private int id_utente;

    @ManyToOne
    @JoinColumn(name="Ente")
    private int id_ente;

    private String nome_donatore;

    private String email_donatore;

    private Date data;

    private double somma;

    

    public int getId_donazione() {
        return id_donazione;
    }
    public void setId_donazione(int id_donazione) {
        this.id_donazione = id_donazione;
    }
    public int getId_utente() {
        return id_utente;
    }
    public void setId_utente(int id_utente) {
        this.id_utente = id_utente;
    }
    public int getId_ente() {
        return id_ente;
    }
    public void setId_ente(int id_ente) {
        this.id_ente = id_ente;
    }
    public String getNome_donatore() {
        return nome_donatore;
    }
    public void setNome_donatore(String nome_donatore) {
        this.nome_donatore = nome_donatore;
    }
    public String getEmail_donatore() {
        return email_donatore;
    }
    public void setEmail_donatore(String email_donatore) {
        this.email_donatore = email_donatore;
    }
    public Date getData() {
        return data;
    }
    public void setData(Date data) {
        this.data = data;
    }
    public double getSomma() {
        return somma;
    }
    public void setSomma(double somma) {
        this.somma = somma;
    }

    
}
