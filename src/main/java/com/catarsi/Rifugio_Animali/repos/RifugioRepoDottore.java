package com.catarsi.Rifugio_Animali.repos;

import com.catarsi.Rifugio_Animali.model.Veterinarian;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.catarsi.Rifugio_Animali.model.Veterinarian;

@Repository
public interface RifugioRepoDottore extends JpaRepository<Veterinarian, Integer> {}

