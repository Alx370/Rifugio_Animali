package com.catarsi.Rifugio_Animali.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.catarsi.Rifugio_Animali.model.Donazione;

@Repository
public interface RifugioRepoDonazione extends JpaRepository<Donazione, Integer> {

    @Query("SELECT SUM(d.somma) FROM Donazione d")
    Double sumDonazioni();
}

