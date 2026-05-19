package com.catarsi.Rifugio_Animali.business.repos;

import com.catarsi.Rifugio_Animali.business.model.Veterinarian;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VeterinarianRepository extends JpaRepository<Veterinarian, Integer> {}

