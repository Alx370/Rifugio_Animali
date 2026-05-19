package com.catarsi.Rifugio_Animali.views.request;

import lombok.Getter;
import lombok.Setter;

import java.util.Optional;

@Setter
@Getter
public class DiaryRequest {
    private Optional<Integer> animal;
    private Optional<String> animalStory;
    private Optional<String> healthStatus;
    private Optional<String> behavioralStatus;
    private Optional<String> vaccinations;
    private Optional<String> performedOperations;
}
