package com.catarsi.Rifugio_Animali.repos;

import com.catarsi.Rifugio_Animali.model.Animale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RifugioRepoAnimale extends JpaRepository<Animale, Integer> {}