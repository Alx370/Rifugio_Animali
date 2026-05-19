package com.catarsi.Rifugio_Animali.business.services;

import com.catarsi.Rifugio_Animali.business.model.Organization;

import java.util.List;

public interface RifugioServiceEnte {

    List<Organization> getAllEnti();

    Organization getEnteById(int id);

    Organization addEnte(Organization organization);

    void delete(int id);
}
