package com.catarsi.Rifugio_Animali.business.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@Entity
@Table(name = "diario")
public class Diary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_animale", nullable = false)
    private Animal animal;

    @Column(name = "storia_animale")
    private String animalStory;

    @Column(name = "stato_salute", nullable = false)
    private String healthStatus;

    @Column(name = "stato_comportamentale", nullable = false)
    private String behavioralStatus;

    @Column(name = "vaccinazioni")
    private String vaccinations;

    @Column(name = "operazioni_effettuate")
    private String performedOperations;

    @Column(name = "creato_il")
    private LocalDateTime createdAt;

    @Column(name = "aggiornato_il")
    private LocalDateTime updatedAt;

}
