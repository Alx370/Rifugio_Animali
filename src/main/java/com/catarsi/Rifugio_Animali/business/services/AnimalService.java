package com.catarsi.Rifugio_Animali.business.services;

import com.catarsi.Rifugio_Animali.business.model.Animal;
import com.catarsi.Rifugio_Animali.views.item.AnimalView;
import com.catarsi.Rifugio_Animali.views.request.AnimalRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;
import java.util.Optional;

public interface AnimalService {

    Page<AnimalView> findAll (Pageable peagable);
    Optional<AnimalView> findById(int id);
    int create(AnimalRequest a);
    void update(AnimalRequest a, int id);
    void delete(int id);

    Specification<Animal> nomeContains(String nome);
    Specification<Animal> sessoEquals(String sesso);
    Specification<Animal> specieEquals(String specie);
    Specification<Animal> razzaContains(String razza);
    Specification<Animal> pesoLessOrEqual(Double peso);
    Specification<Animal> etaLessOrEqual(Integer eta);

    List<Animal> filtraAnimali(String nome, String sesso, String specie, String razza, Double peso, Integer eta);
}

