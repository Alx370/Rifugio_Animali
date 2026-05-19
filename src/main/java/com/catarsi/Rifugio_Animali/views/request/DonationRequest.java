package com.catarsi.Rifugio_Animali.views.request;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

@Getter
@Setter
public class DonationRequest {
    private Optional<Integer> user;
    private Optional<Integer> organization;
    private Optional<LocalDate> date;
    private Optional<BigDecimal> sum;
}
