package com.catarsi.Rifugio_Animali.business.services.impl;

import java.util.List;

import com.catarsi.Rifugio_Animali.business.model.Donation;
import com.catarsi.Rifugio_Animali.business.services.RifugioServiceDonazione;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.catarsi.Rifugio_Animali.business.repos.RifugioRepoDonazione;

@Service
public class RifugioServiceDonazioneImpl implements RifugioServiceDonazione {
    
    @Autowired
    private RifugioRepoDonazione repo_donazione;

    @Override
    public List<Donation> getDonazioni(){
        return repo_donazione.findAll();
    }

    @Override
    public Donation addDonazione(Donation d){
        return repo_donazione.save(d);
    }
    
    @Override
    public Donation getDonazioneById(int id) {
        return repo_donazione.findById(id).orElse(null); // Restituisce null se non trovata
    }

    @Override
    public void delete(int id) {
        repo_donazione.deleteById(id); // Elimina la donazione per ID
    }

    public double sommaDonazioni () {
        return repo_donazione.sumDonazioni();
    }
}








