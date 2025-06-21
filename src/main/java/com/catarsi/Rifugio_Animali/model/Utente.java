package com.catarsi.Rifugio_Animali.model;


import java.util.Date;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;

@Entity
public class Utente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_utente")
    private int id_utente;
    private String nome;
    private String cognome;
    @Email
    @Column(unique = true, nullable = false)
    private String email;
    private String password;
    private String telefono;
    private String sesso;
    @Column(name = "Data_nascita")
    private Date data_nascita;

    
    public int getId_utente() {
        return id_utente;
    }
    public void setId_utente(int id_utente) {
        this.id_utente = id_utente;
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
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
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
    public Date getData_nascita() {
        return data_nascita;
    }
    public void setData_nascita(Date data_nascita) {
        this.data_nascita = data_nascita;
    }

    

}
