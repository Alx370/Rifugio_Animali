package com.catarsi.Rifugio_Animali.business.services;

import com.catarsi.Rifugio_Animali.business.model.Visit;

import java.util.Date;
import java.util.List;

public interface RifugioServicesVisita {

    Visit save(Visit v);               // salva o aggiorna una visita
    List<Visit> getAll();               // ritorna tutte le visite
    Visit getById(int id);              // ritorna visita per id
    void delete(int id);                 // elimina visita per id
    Date getDataVisita(int id);          // ritorna la data della visita per id
}
