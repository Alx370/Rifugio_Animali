package com.catarsi.Rifugio_Animali.business.services;

import java.util.Optional;

import com.catarsi.Rifugio_Animali.views.item.VeterinarianView;
import com.catarsi.Rifugio_Animali.views.request.VeterinarianRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface VeterinarianService {
    Page<VeterinarianView> findAll(Pageable pageable);
    Optional<VeterinarianView> findById(int id);
    int create(VeterinarianRequest veterinarianRequest);
    void update(VeterinarianRequest veterinarianRequest, int id);
    void delete(int id);
}
