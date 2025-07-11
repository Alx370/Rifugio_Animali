package com.catarsi.Rifugio_Animali.services;

import com.catarsi.Rifugio_Animali.model.Ente;

import java.util.List;

public interface RifugioServiceEnte {

    List<Ente> getAllEnti();

    Ente getEnteById(int id);

    Ente addEnte(Ente ente);

    void delete(int id);
}
