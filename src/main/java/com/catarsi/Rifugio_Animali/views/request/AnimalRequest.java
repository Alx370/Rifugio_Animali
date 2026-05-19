package com.catarsi.Rifugio_Animali.views.request;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

@Getter
@Setter
public class AnimalRequest {
    private Optional<String> name;
    private Optional<String> species;
    private Optional<Boolean> microchip;
    private Optional<LocalDate> arrivalDate;
    private Optional<LocalDate> birthDate;
    private Optional<LocalDate> adoptionDate;
    private Optional<String> breed;
    private Optional<Character> gender;
    private Optional<BigDecimal> weight;
    private Optional<String> size;
    private Optional<String> color;
    private Optional<String> distinctiveMarks;
    private Optional<Boolean> spayedNeutered;
    private Optional<Boolean> availableForAdoption;
}
