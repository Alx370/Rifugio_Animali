package com.catarsi.Rifugio_Animali.repos;

import com.catarsi.Rifugio_Animali.model.Adoption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RifugioRepoAdozione extends JpaRepository<Adoption, Integer> {}