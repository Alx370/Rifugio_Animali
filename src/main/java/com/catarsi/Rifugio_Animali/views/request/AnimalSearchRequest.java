package com.catarsi.Rifugio_Animali.views.request;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class AnimalSearchRequest {
    private String nome;
    private String sesso;
    private String specie;
    private String razza;
    private BigDecimal pesoMax;
    private Integer etaMax;
    private Boolean disponibileAdozione;
}
