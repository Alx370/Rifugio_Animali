package com.catarsi.Rifugio_Animali.services;

import com.catarsi.Rifugio_Animali.model.Visita;

import java.util.List;

public interface RifugioServicesVisita {

    Visita addVisita(Visita v);
    List<Visita> getVisite();
}
