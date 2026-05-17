package com.catarsi.Rifugio_Animali.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

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

    @OneToOne
    @JoinColumn(name = "id_animale")
    private Animal animal;

    @Column(name = "storia_animale")
    private String animal_story;

    @Column(name = "stato_salute", nullable = false)
    private String wealth_status;

    @Column(name = "stato_comportamentale", nullable = false)
    private String beahvioral_status;

    @Column(name = "vaccinazioni")
    private String vaccinations;

    @Column(name = "operazioni_effettuate")
    private String ointments_made;

    @Column(name = "created_at")
    private LocalDateTime created_at;

    @Column(name = "updated_at")
    private LocalDateTime updated_at;

}
