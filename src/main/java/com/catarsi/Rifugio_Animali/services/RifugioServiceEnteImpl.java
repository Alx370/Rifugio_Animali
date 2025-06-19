package com.catarsi.Rifugio_Animali.services;

import com.catarsi.Rifugio_Animali.model.Ente;
import com.catarsi.Rifugio_Animali.repos.RifugioRepoEnte;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RifugioServiceEnteImpl implements RifugioServiceEnte{

    @Autowired
    private RifugioRepoEnte ente_repo;

    @Override
    public Ente addEnte(Ente e) {
        return ente_repo.save(e);
    }

    @Override
    public List<Ente> getEnti() {
        return ente_repo.findAll();
    }
}
