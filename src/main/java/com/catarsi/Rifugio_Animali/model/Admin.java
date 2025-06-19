package com.catarsi.Rifugio_Animali.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id_admin;
    private String email;
    private String password;
    
    public int getId_admin() {
        return id_admin;
    }
    public void setId_admin(int id_admin) {
        this.id_admin = id_admin;
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
    
}
