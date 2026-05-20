package com.catarsi.Rifugio_Animali.business.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.catarsi.Rifugio_Animali.business.model.Donation;

import java.math.BigDecimal;
import java.util.Optional;

@Repository
public interface DonationRepository extends JpaRepository<Donation, Integer> {
    @Query("SELECT COALESCE(SUM(d.sum), 0) FROM Donation d")
    BigDecimal sumDonations();

    Page<Donation> findByUserEmail(String email, Pageable pageable);
    Optional<Donation> findByIdAndUserEmail(int id, String email);
}
