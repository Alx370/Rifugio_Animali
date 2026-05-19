package com.catarsi.Rifugio_Animali.business.services;

import java.util.Optional;

import com.catarsi.Rifugio_Animali.views.item.DiaryView;
import com.catarsi.Rifugio_Animali.views.request.DiaryRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface DiaryService {

    Page<DiaryView> findAll (Pageable pageable);
    Optional<DiaryView> findById(int id);
    int create(DiaryRequest d);
    void update(DiaryRequest d, int id);
    void delete(int id);
}
