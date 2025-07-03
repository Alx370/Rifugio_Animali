package com.catarsi.Rifugio_Animali.services;

import com.catarsi.Rifugio_Animali.model.Ente;
import java.util.List;

public interface RifugioServiceEnte {

    Ente save(Ente e);          // crea o aggiorna un ente
    List<Ente> getAll();       // restituisce tutti gli enti
    Ente getById(Long id);      // restituisce un ente per id
    void delete(Long id);       // elimina un ente per id
}
