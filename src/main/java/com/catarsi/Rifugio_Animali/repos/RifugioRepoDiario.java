package com.catarsi.Rifugio_Animali.repos;

import jakarta.transaction.Transactional;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.catarsi.Rifugio_Animali.model.Diario;

@Repository
public interface RifugioRepoDiario extends JpaRepository<Diario, Integer> {

    @Transactional
    @Modifying
    @Query("DELETE FROM Diario d WHERE d.animale.id = :id")
    void deleteByAnimaleId(@Param("id") int id);

//    @Modifying
//    @Transactional
//    @Query(value = "INSERT INTO diario (data, descrizione, animale_id) VALUES (:data, :descrizione, :animaleId)", nativeQuery = true)
//    void insertDiarioNative(@Param("data") LocalDate data, @Param("descrizione") String descrizione, @Param("animaleId") int animaleId);

    @Query("SELECT d FROM Diario d WHERE d.animale.id_animale = :idAnimale")
    Diario findByAnimaleId(@Param("idAnimale") int idAnimale);

}


