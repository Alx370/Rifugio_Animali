package com.catarsi.Rifugio_Animali.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Dottore {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id_dottore;
    private String nome;
    private String cognome;
    private String email;
    private String telefono;
    private String sesso;
    
    public int getId_dottore() {
        return id_dottore;
    }
    public void setId_dottore(int id_dottore) {
        this.id_dottore = id_dottore;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCognome() {
        return cognome;
    }
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public String getSesso() {
        return sesso;
    }
    public void setSesso(String sesso) {
        this.sesso = sesso;
    }

    
}
