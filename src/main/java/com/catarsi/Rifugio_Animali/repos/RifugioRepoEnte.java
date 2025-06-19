package com.catarsi.Rifugio_Animali.repos;

import com.catarsi.Rifugio_Animali.model.Ente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RifugioRepoEnte extends JpaRepository<Ente, Integer> {
}
