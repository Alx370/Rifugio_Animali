package com.catarsi.Rifugio_Animali.repos;

import com.catarsi.Rifugio_Animali.model.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RifugioRepoEnte extends JpaRepository<Organization, Integer> {
}
