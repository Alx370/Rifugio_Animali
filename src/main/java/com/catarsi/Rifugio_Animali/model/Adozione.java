package com.catarsi.Rifugio_Animali.model;

import java.util.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "Adozione")
public class Adozione {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_adozione")
    private int id_adozione;
    
    @OneToOne
    @JoinColumn(name="Id_animale")
    private Animale animale ;

    @ManyToOne
    @JoinColumn(name="Id_utente")
    private Utente utente;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "data_adozione")
    private Date data_adozione;

    public int getId_adozione() {
        return id_adozione;
    }

    public void setId_adozione(int id_adozione) {
        this.id_adozione = id_adozione;
    }

    public Animale getAnimale() {
        return animale;
    }

    public void setAnimale(Animale animale) {
        this.animale = animale;
    }

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    public Date getData_adozione() {
        return data_adozione;
    }

    public void setData_adozione(Date data_adozione) {
        this.data_adozione = data_adozione;
    }

    

    
}
