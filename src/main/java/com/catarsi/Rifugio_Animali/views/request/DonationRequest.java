package com.catarsi.Rifugio_Animali.views.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

@Getter
@Setter
public class DonationRequest {
    private Optional<@NotNull Integer> organization;
    private Optional<LocalDate> date;
    private Optional<@Positive BigDecimal> sum;
}
