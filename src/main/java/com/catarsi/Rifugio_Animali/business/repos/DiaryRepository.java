package com.catarsi.Rifugio_Animali.business.repos;

import jakarta.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.catarsi.Rifugio_Animali.business.model.Diary;

@Repository
public interface DiaryRepository extends JpaRepository<Diary, Integer> {

    @Transactional
    @Modifying
    @Query("DELETE FROM Diary d WHERE d.animal.id = :id")
    void deleteByAnimaleId(@Param("id") int id);

    @Query("SELECT d FROM Diary d WHERE d.animal.id = :idAnimale")
    Diary findByAnimaleId(@Param("idAnimale") int idAnimale);

}


