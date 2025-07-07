package com.catarsi.Rifugio_Animali.services;

import java.util.List;
import com.catarsi.Rifugio_Animali.model.Donazione;

public interface RifugioServiceDonazione {

    Donazione addDonazione(Donazione d);

    List<Donazione> getDonazioni();

    Donazione getDonazioneById(int id);  // Metodo per ottenere una donazione per id

    void delete(int id);  // Metodo per cancellare una donazione per id
}
