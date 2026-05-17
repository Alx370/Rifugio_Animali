package com.catarsi.Rifugio_Animali.repos;

import java.util.Optional;

import com.catarsi.Rifugio_Animali.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import com.catarsi.Rifugio_Animali.model.User;

public interface RifugioRepoUtente extends JpaRepository<User, Integer> {
    Optional<User> findByEmail(String email);
}
