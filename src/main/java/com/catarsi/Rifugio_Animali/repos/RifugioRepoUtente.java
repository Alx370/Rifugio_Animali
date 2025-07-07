package com.catarsi.Rifugio_Animali.repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.catarsi.Rifugio_Animali.model.Utente;

public interface RifugioRepoUtente extends JpaRepository<Utente, Integer> {
    Optional<Utente> findByEmail(String email);
    
}
