package com.catarsi.Rifugio_Animali.services;

import com.catarsi.Rifugio_Animali.model.Animale;
import com.catarsi.Rifugio_Animali.model.Diario;
import com.catarsi.Rifugio_Animali.repos.RifugioRepoAnimale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RifugioServiceAnimaliImpl implements RifugioServiceAnimali {

    @Autowired
    private RifugioRepoAnimale animali_repo;

    @Override
    public Animale addAnimale(Animale a) {
        return animali_repo.save(a);
    }

    @Override
    public List<Animale> getAnimali() {
        return animali_repo.findAll();
    }

    @Override
    public Animale getAnimaleByIdAnimale(int id) {
        return animali_repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Animale non trovato con ID: " + id));
    }



}






