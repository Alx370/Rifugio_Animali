package com.catarsi.Rifugio_Animali.repos;

import com.catarsi.Rifugio_Animali.model.Visita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RifugioRepoVisita extends JpaRepository<Visita, Integer> {}
