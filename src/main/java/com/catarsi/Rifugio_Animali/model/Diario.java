package com.catarsi.Rifugio_Animali.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "diario")
public class Diario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_diario")
    private int id_diario;

    @OneToOne
    @JoinColumn(name="Id_animale")
    private Animale animale;

    @Column(name = "storia_animale")
    private String storia_animale;

    @Column(name = "stato_salute", nullable = false)
    private String stato_salute;

    @Column(name = "stato_comportamentale", nullable = false)
    private String stato_comportamentale;

    @Column(name = "vaccinazioni")
    private String vaccinazioni;
    
    @Column(name = "operazioni_effettuate")
    private String operazioni_effettuate;
    
    public Diario() {}

    public int getId_diario() {
        return id_diario;
    }

    public void setId_diario(int id_diario) {
        this.id_diario = id_diario;
    }

    public Animale getAnimale() {
        return animale;
    }

    public void setAnimale(Animale animale) {
        this.animale = animale;
    }

    public String getStoria_animale() {
        return storia_animale;
    }

    public void setStoria_animale(String storia_animale) {
        this.storia_animale = storia_animale;
    }

    public String getStato_salute() {
        return stato_salute;
    }

    public void setStato_salute(String stato_salute) {
        this.stato_salute = stato_salute;
    }

    public String getStato_comportamentale() {
        return stato_comportamentale;
    }

    public void setStato_comportamentale(String stato_comportamentale) {
        this.stato_comportamentale = stato_comportamentale;
    }

    public String getVaccinazioni() {
        return vaccinazioni;
    }

    public void setVaccinazioni(String vaccinazioni) {
        this.vaccinazioni = vaccinazioni;
    }

    public String getOperazioni_effettuate() {
        return operazioni_effettuate;
    }

    public void setOperazioni_effettuate(String operazioni_effettuate) {
        this.operazioni_effettuate = operazioni_effettuate;
    }

    

}
