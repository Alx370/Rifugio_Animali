package com.catarsi.Rifugio_Animali.business.model;

import java.math.BigDecimal;
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
import jakarta.persistence.Table;

@Setter
@Getter
@Entity
@Table(name = "animale")
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "specie", nullable = false)
    private String species;

    @Column(name = "nome")
    private String name;

    @Column(name = "microchip")
    private boolean microchip = false;

    @Column(name = "data_arrivo", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate arrivalDate;

    @Column(name = "data_nascita")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthDate;

    @Column(name = "data_adozione")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate adoptionDate;

    @Column(name = "razza")
    private String breed;

    @Column(name = "sesso", nullable = false, length = 1)
    private Character gender;

    @Column(name = "peso", nullable = false)
    private BigDecimal weight;

    @Column(name = "taglia", nullable = false)
    private String size;

    @Column(name = "colore", nullable = false)
    private String color;

    @Column(name = "segni_particolari")
    private String distinctiveMarks;

    @Column(name = "sterilizzato")
    private boolean spayedNeutered = false;

    @Column(name = "disponibile_adozione")
    private boolean availableForAdoption = true;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public double getWeight() {
        return weight == null ? 0.0 : weight.doubleValue();
    }

    public void setWeight(double weight) {
        this.weight = BigDecimal.valueOf(weight);
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public void setAdoptionDate(java.util.Date adoptionDate) {
        this.adoptionDate = adoptionDate == null
                ? null
                : new java.sql.Date(adoptionDate.getTime()).toLocalDate();
    }

    public void setAdoptionDate(LocalDate adoptionDate) {
        this.adoptionDate = adoptionDate;
    }
}