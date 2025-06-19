package com.catarsi.Rifugio_Animali.services;

import com.catarsi.Rifugio_Animali.model.Animale;

import java.util.List;

public interface RifugioServiceAnimali {

    Animale addAnimale(Animale a);
    List<Animale> getAnimali();
}
