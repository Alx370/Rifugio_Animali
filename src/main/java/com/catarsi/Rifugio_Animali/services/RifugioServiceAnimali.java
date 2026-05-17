package com.catarsi.Rifugio_Animali.services;

import com.catarsi.Rifugio_Animali.model.Animal;
import com.catarsi.Rifugio_Animali.model.Animal;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public interface RifugioServiceAnimali {

    Animal addAnimale(Animal a);
    void deleteAnimale(int id);
    List<Animal> getAnimali();

    Animal getAnimaleByIdAnimale(int id);

    Specification<Animal> nomeContains(String nome);
    Specification<Animal> sessoEquals(String sesso);
    Specification<Animal> specieEquals(String specie);
    Specification<Animal> razzaContains(String razza);
    Specification<Animal> pesoLessOrEqual(Double peso);
    Specification<Animal> etaLessOrEqual(Integer eta);

    List<Animal> filtraAnimali(String nome, String sesso, String specie, String razza, Double peso, Integer eta);
}


