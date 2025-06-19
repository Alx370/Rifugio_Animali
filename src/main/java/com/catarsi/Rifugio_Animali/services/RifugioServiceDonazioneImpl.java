package com.catarsi.Rifugio_Animali.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.catarsi.Rifugio_Animali.model.Donazione;
import com.catarsi.Rifugio_Animali.repos.RifugioRepoDonazione;

@Service
public class RifugioServiceDonazioneImpl implements RifugioServiceDonazione{
    
    @Autowired
    private RifugioRepoDonazione repo_donazione;

    @Override
    public List<Donazione> getDonazioni(){
        return repo_donazione.findAll();
    }

    @Override
    public Donazione addDonazione(Donazione d){
        return repo_donazione.save(d);
    }
    
}








