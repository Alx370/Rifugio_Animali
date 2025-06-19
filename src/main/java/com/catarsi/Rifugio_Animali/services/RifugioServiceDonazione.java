package com.catarsi.Rifugio_Animali.services;

import java.util.List;

import com.catarsi.Rifugio_Animali.model.Donazione;

public interface RifugioServiceDonazione {
    
    Donazione addDonazione(Donazione d);
    List<Donazione> addDonazioni();
}
