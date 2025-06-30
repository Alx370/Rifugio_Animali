package com.catarsi.Rifugio_Animali.repos;

import com.catarsi.Rifugio_Animali.model.Utente;

import java.util.Optional;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RifugioRepoUtente extends JpaRepository<Utente, Integer> {
    Optional<Utente> findByEmail(String email);
}
