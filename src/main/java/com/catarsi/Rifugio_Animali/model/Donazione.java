package com.catarsi.Rifugio_Animali.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;


@Entity
@Table(name = "donazione")
public class Donazione {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_donazione")
    private int id_donazione;

    @ManyToOne
    @JoinColumn(name = "Id_utente")
    private Utente utente;

    @ManyToOne
    @JoinColumn(name = "id_ente")
    private Ente ente;

    @Column(name = "nome_donatore", nullable = false)
    private String nome_donatore;

    @Column(name = "email_donatore")
    private String email_donatore;

    @Temporal(TemporalType.DATE)
    @Column(name = "data", nullable = false)
    private Date data;

    @Column(name = "somma", nullable = false)
    private double somma;

    public Donazione() {}

    public int getId_donazione() {
        return id_donazione;
    }

    public void setId_donazione(int id_donazione) {
        this.id_donazione = id_donazione;
    }

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    public Ente getEnte() {
        return ente;
    }

    public void setEnte(Ente ente) {
        this.ente = ente;
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