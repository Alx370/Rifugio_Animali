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
public class Visita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id_visita;

    @ManyToOne
    @JoinColumn(name="Animale")
    private int id_animale;

    @OneToMany
    @JoinColumn(name="Dottore")
    private int id_dottore;

    private Date data_visita;

    private String descrizione;

    public int getId_visita() {
        return id_visita;
    }

    public void setId_visita(int id_visita) {
        this.id_visita = id_visita;
    }

    public int getId_animale() {
        return id_animale;
    }

    public void setId_animale(int id_animale) {
        this.id_animale = id_animale;
    }

    public int getId_dottore() {
        return id_dottore;
    }

    public void setId_dottore(int id_dottore) {
        this.id_dottore = id_dottore;
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
