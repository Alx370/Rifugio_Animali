package com.catarsi.Rifugio_Animali.services;

import com.catarsi.Rifugio_Animali.model.Visita;

import java.util.List;

public interface RifugioServicesVisita {

    Visita save(Visita v);            // salva o aggiorna una visita
    List<Visita> getAll();            // ritorna tutte le visite
    Visita getById(Long id);          // ritorna visita per id
    void delete(Long id);             // elimina visita per id
}
