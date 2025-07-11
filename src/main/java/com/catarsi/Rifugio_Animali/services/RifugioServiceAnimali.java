package com.catarsi.Rifugio_Animali.services;

import com.catarsi.Rifugio_Animali.model.Animale;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public interface RifugioServiceAnimali {

    Animale addAnimale(Animale a);
    void deleteAnimale(int id);
    List<Animale> getAnimali();

    Animale getAnimaleByIdAnimale(int id);

    Specification<Animale> nomeContains(String nome);
    Specification<Animale> sessoEquals(String sesso);
    Specification<Animale> specieEquals(String specie);
    Specification<Animale> razzaContains(String razza);
    Specification<Animale> pesoLessOrEqual(Double peso);
    Specification<Animale> etaLessOrEqual(Integer eta);

    List<Animale> filtraAnimali(String nome, String sesso, String specie, String razza, Double peso, Integer eta);
}


