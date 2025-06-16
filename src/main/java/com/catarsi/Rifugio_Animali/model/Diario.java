package com.catarsi.Rifugio_Animali.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Diario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id_diario;

    @OneToOne
    @JoinColumn(name="Animale")
    private int id_animale;

    private String storia_animale;

    private String stato_salute;

    private String stato_comportamentale;

    private String vaccinazioni;
    
    private String operazioni_effettuate;
    

    public int getId_diario() {
        return id_diario;
    }

    public int getId_animale() {
        return id_animale;
    }

    public String getStoria_animale() {
        return storia_animale;
    }

    public String getStato_salute() {
        return stato_salute;
    }

    public String getStato_comportamentale() {
        return stato_comportamentale;
    }

    public String getVaccinazioni() {
        return vaccinazioni;
    }

    public String getOperazioni_effettuate() {
        return operazioni_effettuate;
    }

}
