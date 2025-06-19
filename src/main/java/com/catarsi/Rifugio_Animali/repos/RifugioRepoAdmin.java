package com.catarsi.Rifugio_Animali.repos;

import com.catarsi.Rifugio_Animali.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RifugioRepoAdmin extends JpaRepository<Admin, Integer> {
}
