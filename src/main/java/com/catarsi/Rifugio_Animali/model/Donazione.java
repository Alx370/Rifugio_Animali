package com.catarsi.Rifugio_Animali.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

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

    @ManyToOne(optional = false)
    @JoinColumn(name = "Id_utente")
    private Utente utente;

    @ManyToOne
    @JoinColumn(name = "Id_ente")
    private Ente ente;

    @Temporal(TemporalType.DATE)
    @Column(name = "data", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
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