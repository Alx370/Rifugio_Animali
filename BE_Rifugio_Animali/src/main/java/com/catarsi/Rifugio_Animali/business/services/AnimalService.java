package com.catarsi.Rifugio_Animali.business.services;

import com.catarsi.Rifugio_Animali.business.model.Animal;
import com.catarsi.Rifugio_Animali.views.item.AnimalView;
import com.catarsi.Rifugio_Animali.views.request.AnimalRequest;
import com.catarsi.Rifugio_Animali.views.request.AnimalSearchRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.math.BigDecimal;
import java.util.Optional;

public interface AnimalService {

    Page<AnimalView> findAll (Pageable peagable);
    Page<AnimalView> search(AnimalSearchRequest request, Pageable pageable);
    Optional<AnimalView> findById(int id);
    int create(AnimalRequest a);
    void update(AnimalRequest a, int id);
    void delete(int id);

    Specification<Animal> nomeContains(String nome);
    Specification<Animal> sessoEquals(String sesso);
    Specification<Animal> specieEquals(String specie);
    Specification<Animal> razzaContains(String razza);
    Specification<Animal> pesoLessOrEqual(BigDecimal pesoMax);
    Specification<Animal> etaLessOrEqual(Integer etaMax);
    Specification<Animal> disponibileAdozioneEquals(Boolean disponibileAdozione);
}
