package com.catarsi.Rifugio_Animali.views.item;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class VisitView {
    private int id;
    private AnimalView animal;
    private UserView user;
    private VeterinarianView veterinarian;
    private LocalDate visitDate;
    private String visitType;
    private String description;
    private BigDecimal cost;
    private String status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
