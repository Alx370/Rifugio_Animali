package com.catarsi.Rifugio_Animali.services;

import com.catarsi.Rifugio_Animali.model.Visita;
import com.catarsi.Rifugio_Animali.repos.RifugioRepoVisita;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RifugioServicesVisitaImpl implements RifugioServicesVisita{

    @Autowired
    private RifugioRepoVisita visita_repo;

    @Override
    public Visita addVisita(Visita v) {
        return visita_repo.save(v);
    }

    @Override
    public List<Visita> getVisite() {
        return visita_repo.findAll();
    }

    public Visita salvaVisita(Visita v){
        return visita_repo.save(v);
    }
}
