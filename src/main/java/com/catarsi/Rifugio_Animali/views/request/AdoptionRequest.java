package com.catarsi.Rifugio_Animali.views.request;

import com.catarsi.Rifugio_Animali.business.model.User;
import com.catarsi.Rifugio_Animali.views.item.AnimalView;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Optional;

@Getter
@Setter
public class AdoptionRequest {
    private Optional<Integer> animal;
    private Optional<Integer> user;
    private Optional<LocalDate> adoptionDate;
    private Optional<String> note;
    private Optional<String> status;
}
