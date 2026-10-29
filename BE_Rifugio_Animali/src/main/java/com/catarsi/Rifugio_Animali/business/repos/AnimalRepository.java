package com.catarsi.Rifugio_Animali.business.repos;

import com.catarsi.Rifugio_Animali.business.model.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Integer>, JpaSpecificationExecutor<Animal> {}

