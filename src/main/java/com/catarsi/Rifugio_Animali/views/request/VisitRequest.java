package com.catarsi.Rifugio_Animali.views.request;

import com.catarsi.Rifugio_Animali.business.model.enums.RequestStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

@Getter
@Setter
public class VisitRequest {
    private Optional<@NotNull Integer> animal;
    private Optional<@NotNull Integer> user;
    private Optional<@NotNull Integer> veterinarian;
    private Optional<LocalDate> visitDate;
    private Optional<@NotBlank String> visitType;
    private Optional<@NotBlank String> description;
    private Optional<@PositiveOrZero BigDecimal> cost;
    private Optional<RequestStatus> status;
}
