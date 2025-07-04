package com.catarsi.Rifugio_Animali.services;

import com.catarsi.Rifugio_Animali.model.Ente;
import com.catarsi.Rifugio_Animali.repos.RifugioRepoEnte;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RifugioServiceEnteImpl implements RifugioServiceEnte {

    @Autowired
    private RifugioRepoEnte enteRepo;

    @Override
    public Ente save(Ente e) {
        return enteRepo.save(e);
    }

    @Override
    public List<Ente> getAll() {
        return enteRepo.findAll();
    }

    @Override
    public Ente getById(Integer id) {
        return enteRepo.findById(id).orElse(null);
    }

    @Override
    public void delete(Integer id) {
        enteRepo.deleteById(id);
    }
}
