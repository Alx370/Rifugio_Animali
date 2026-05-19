package com.catarsi.Rifugio_Animali.views.request;

import lombok.Getter;
import lombok.Setter;

import java.util.Optional;

@Setter
@Getter
public class DiaryRequest {
    private Optional<Integer> animal;
    private Optional<String> animal_story;
    private Optional<String> wealth_status;
    private Optional<String> beahvioral_status;
    private Optional<String> vaccinations;
    private Optional<String> ointments_made;
}
