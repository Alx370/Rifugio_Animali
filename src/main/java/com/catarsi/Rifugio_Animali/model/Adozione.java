package com.catarsi.Rifugio_Animali.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Adozione {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id_adozione;

    @OneToOne
    @JoinColumn(name="Animale")
    private int id_animale ;

    @OneToMany
    @JoinColumn(name="Utente")
    private int id_utente;
    
    private Date data_adozione;


    public int getId_adozione() {
        return id_adozione;
    }
    public void setId_adozione(int id_adozione) {
        this.id_adozione = id_adozione;
    }
    public int getId_animale() {
        return id_animale;
    }
    public void setId_animale(int id_animale) {
        this.id_animale = id_animale;
    }
    public int getId_utente() {
        return id_utente;
    }
    public void setId_utente(int id_utente) {
        this.id_utente = id_utente;
    }
    public Date getData_adozione() {
        return data_adozione;
    }
    public void setData_adozione(Date data_adozione) {
        this.data_adozione = data_adozione;
    }

    
}
