package com.catarsi.Rifugio_Animali.repos;

import com.catarsi.Rifugio_Animali.model.Visit;
import jakarta.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RifugioRepoVisita extends JpaRepository<Visit, Integer> {


    @Transactional
    @Modifying
    @Query("DELETE FROM Visit v WHERE v.animale.id = :id")
    void deleteByAnimaleId(@Param("id") int id);
}
