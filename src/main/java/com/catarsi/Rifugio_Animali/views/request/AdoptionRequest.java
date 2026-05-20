package com.catarsi.Rifugio_Animali.views.request;

import com.catarsi.Rifugio_Animali.business.model.enums.RequestStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Optional;

@Getter
@Setter
public class AdoptionRequest {
    private Optional<@NotNull Integer> animal;
    private Optional<LocalDate> adoptionDate;
    private Optional<@NotBlank String> note;
    private Optional<RequestStatus> status;
}
