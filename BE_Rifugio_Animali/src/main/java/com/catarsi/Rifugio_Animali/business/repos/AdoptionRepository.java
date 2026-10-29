package com.catarsi.Rifugio_Animali.business.repos;

import com.catarsi.Rifugio_Animali.business.model.Adoption;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdoptionRepository extends JpaRepository<Adoption, Integer> {
    Page<Adoption> findByUserEmail(String email, Pageable pageable);
    Optional<Adoption> findByIdAndUserEmail(int id, String email);
}
