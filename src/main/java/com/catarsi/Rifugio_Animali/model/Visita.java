package com.catarsi.Rifugio_Animali.model;

import java.time.LocalDate;
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
@Table(name = "visita")
public class Visita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "Id_visita")
    private int id_visita;

    @ManyToOne
    @JoinColumn(name = "Id_animale", nullable = false)
    private Animale animale;

    @ManyToOne
    @JoinColumn(name = "Id_dottore", nullable = false)
    private Dottore dottore;

    @Temporal(TemporalType.DATE)
    @Column(name = "data_visita", nullable = false)
    private Date data_visita;

    @Column(name = "descrizione", columnDefinition = "TEXT")
    private String descrizione;

    public Visita() {}

    public int getId_visita() {
        return id_visita;
    }

    public void setId_visita(int id_visita) {
        this.id_visita = id_visita;
    }

    public Animale getAnimale() {
        return animale;
    }

    public void setAnimale(Animale animale) {
        this.animale = animale;
    }

    public Dottore getDottore() {
        return dottore;
    }

    public void setDottore(Dottore dottore) {
        this.dottore = dottore;
    }

    public Date getData_visita() {
        return data_visita;
    }

    public void setData_visita(Date data_visita) {
        this.data_visita = data_visita;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

}
