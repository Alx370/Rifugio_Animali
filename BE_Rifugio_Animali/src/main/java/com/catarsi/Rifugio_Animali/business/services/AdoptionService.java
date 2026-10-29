package com.catarsi.Rifugio_Animali.business.services;

import java.util.Optional;

import com.catarsi.Rifugio_Animali.views.item.AdoptionView;
import com.catarsi.Rifugio_Animali.views.request.AdoptionRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AdoptionService {
    Page<AdoptionView> findAll (Pageable peagable);
    Page<AdoptionView> findAll(Pageable pageable, String userEmail, boolean admin);
    Optional<AdoptionView> findById(int id);
    Optional<AdoptionView> findById(int id, String userEmail, boolean admin);
    int create(AdoptionRequest a, String userEmail);
    void update(AdoptionRequest a, int id);
    void delete(int id);
}
