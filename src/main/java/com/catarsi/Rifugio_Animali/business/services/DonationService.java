package com.catarsi.Rifugio_Animali.business.services;

import java.util.Optional;

import com.catarsi.Rifugio_Animali.views.item.DonationView;
import com.catarsi.Rifugio_Animali.views.request.DonationRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface DonationService {
    Page<DonationView> findAll(Pageable pageable);
    Optional<DonationView> findById(int id);
    int create(DonationRequest donationRequest);
    void update(DonationRequest donationRequest, int id);
    void delete(int id);
}
