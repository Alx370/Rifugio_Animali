package com.catarsi.Rifugio_Animali.views.item;

import com.catarsi.Rifugio_Animali.business.model.Organization;
import com.catarsi.Rifugio_Animali.business.model.User;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class DonationView {
    private int id;
    private User user;
    private Organization organization;
    private LocalDate date;
    private BigDecimal sum;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
