package com.catarsi.Rifugio_Animali.views.item;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Setter
@Getter
@ToString
public class AnimalView {
    private int id;
    private String species;
    private String name;
    private boolean microchip;
    private LocalDate arrivalDate;
    private LocalDate birthDate;
    private LocalDate adoptionDate;
    private String breed;
    private Character gender;
    private BigDecimal weight;
    private String size;
    private String color;
    private String distinctiveMarks;
    private boolean spayedNeutered;
    private boolean availableForAdoption;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
