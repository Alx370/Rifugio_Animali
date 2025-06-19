package com.catarsi.Rifugio_Animali.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.catarsi.Rifugio_Animali.model.Diario;

@Repository
public interface RifugioRepoDiario extends JpaRepository<Diario, Integer> {}
