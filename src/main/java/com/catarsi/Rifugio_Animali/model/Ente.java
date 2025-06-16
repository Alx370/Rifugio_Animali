package com.catarsi.Rifugio_Animali.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Ente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id_ente;
    private String nome;
    private String email;
    private String telefono;

    
    public int getId_ente() {
        return id_ente;
    }
    public void setId_ente(int id_ente) {
        this.id_ente = id_ente;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
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
    
}
