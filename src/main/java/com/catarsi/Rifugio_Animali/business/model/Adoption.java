package com.catarsi.Rifugio_Animali.business.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Setter
@Getter
@Entity
@Table(name = "adozione")
public class Adoption {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    
    @OneToOne
    @JoinColumn(name="id_animale", nullable = false, unique = true)
    private Animal animal;

    @ManyToOne
    @JoinColumn(name="id_utente", nullable = false)
    private User user;
    
    @Column(name = "data_adozione", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date_adoption;

    @Column(name = "note")
    private String note;

    @Column(name = "created_at")
    private LocalDateTime created_at;

    @Column(name = "updated_at")
    private LocalDateTime updated_at;

    public java.util.Date getData_adozione() {
        return date_adoption == null ? null : java.sql.Date.valueOf(date_adoption);
    }

    public void setData_adozione(java.util.Date date_adoption) {
        this.date_adoption = date_adoption== null
                ? null
                : new java.sql.Date(date_adoption.getTime()).toLocalDate();
    }
}
