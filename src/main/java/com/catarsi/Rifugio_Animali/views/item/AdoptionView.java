package com.catarsi.Rifugio_Animali.views.item;

import com.catarsi.Rifugio_Animali.business.model.User;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class AdoptionView {
    private int id;
    private AnimalView animal;
    private User user;
    private LocalDate adoptionDate;
    private String note;
    private String status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
