package com.catarsi.Rifugio_Animali.business.services;

import com.catarsi.Rifugio_Animali.business.model.Organization;
import com.catarsi.Rifugio_Animali.views.item.OrganizationView;
import com.catarsi.Rifugio_Animali.views.request.OrganizationRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface OrganizationService {
    Page<OrganizationView> findAll(Pageable pageable);
    Optional<OrganizationView> findById(int id);
    int create(OrganizationRequest organizationRequest);
    void update(OrganizationRequest organizationRequest, int id);
    void delete(int id);
}
