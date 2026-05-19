package com.catarsi.Rifugio_Animali.views.item;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class DiaryView {
    private int id;
    private AnimalView animal;
    private String animalStory;
    private String healthStatus;
    private String behavioralStatus;
    private String vaccinations;
    private String performedOperations;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
