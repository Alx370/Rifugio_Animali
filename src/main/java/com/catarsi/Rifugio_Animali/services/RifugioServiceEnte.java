package com.catarsi.Rifugio_Animali.services;

import com.catarsi.Rifugio_Animali.model.Organization;

import java.util.List;

public interface RifugioServiceEnte {

    List<Organization> getAllEnti();

    Organization getEnteById(int id);

    Organization addEnte(Organization organization);

    void delete(int id);
}
