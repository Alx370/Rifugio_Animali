package com.catarsi.Rifugio_Animali.repos;

import com.catarsi.Rifugio_Animali.model.Animal;
import com.catarsi.Rifugio_Animali.model.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface RifugioRepoAnimale extends JpaRepository<Animal, Integer>, JpaSpecificationExecutor<Animal> {}

