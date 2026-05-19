package com.catarsi.Rifugio_Animali.business.services;

import com.catarsi.Rifugio_Animali.views.item.VisitView;
import com.catarsi.Rifugio_Animali.views.request.VisitRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface VisitService {
    Page<VisitView> findAll(Pageable pageable);
    Optional<VisitView> findById(int id);
    int create(VisitRequest visitRequest);
    void update(VisitRequest visitRequest, int id);
    void delete(int id);
}
