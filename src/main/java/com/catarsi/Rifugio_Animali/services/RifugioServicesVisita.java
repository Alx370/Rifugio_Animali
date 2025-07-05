package com.catarsi.Rifugio_Animali.services;

import com.catarsi.Rifugio_Animali.model.Visita;

import java.util.Date;
import java.util.List;

public interface RifugioServicesVisita {

    Visita save(Visita v);               // salva o aggiorna una visita
    List<Visita> getAll();               // ritorna tutte le visite
    Visita getById(int id);              // ritorna visita per id
    void delete(int id);                 // elimina visita per id
    Date getDataVisita(int id);          // ritorna la data della visita per id
}
