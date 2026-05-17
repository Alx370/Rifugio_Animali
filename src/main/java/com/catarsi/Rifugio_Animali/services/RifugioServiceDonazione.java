package com.catarsi.Rifugio_Animali.services;

import java.util.List;

import com.catarsi.Rifugio_Animali.model.Donation;

public interface RifugioServiceDonazione {

    Donation addDonazione(Donation d);

    List<Donation> getDonazioni();

    Donation getDonazioneById(int id);  // Metodo per ottenere una donazione per id

    void delete(int id);  // Metodo per cancellare una donazione per id

    double sommaDonazioni();
        
}
