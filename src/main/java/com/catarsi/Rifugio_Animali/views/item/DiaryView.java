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
    private String animal_story;
    private String wealth_status;
    private String beahvioral_status;
    private String vaccinations;
    private String ointments_made;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
}
