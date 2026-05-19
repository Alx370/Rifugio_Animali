package com.catarsi.Rifugio_Animali.views.request;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

@Getter
@Setter
public class VisitRequest {
    private Optional<Integer> animal;
    private Optional<Integer> veterinarian;
    private Optional<LocalDate> visitDate;
    private Optional<String> visitType;
    private Optional<String> description;
    private Optional<BigDecimal> cost;
}
