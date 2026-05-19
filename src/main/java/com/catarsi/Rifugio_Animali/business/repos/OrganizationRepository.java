package com.catarsi.Rifugio_Animali.business.repos;

import com.catarsi.Rifugio_Animali.business.model.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganizationRepository extends JpaRepository<Organization, Integer> {
}
