package com.catarsi.Rifugio_Animali.services;

import com.catarsi.Rifugio_Animali.model.Animale;
import com.catarsi.Rifugio_Animali.model.Diario;
import com.catarsi.Rifugio_Animali.repos.RifugioRepoAnimale;
import com.catarsi.Rifugio_Animali.repos.RifugioRepoDiario;
import com.catarsi.Rifugio_Animali.repos.RifugioRepoVisita;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RifugioServiceAnimaliImpl implements RifugioServiceAnimali {

    @Autowired
    private RifugioRepoAnimale animali_repo;

    @Autowired
    private RifugioRepoDiario diarioRepo;

    @Autowired
    private RifugioRepoVisita visitaRepo;

    @Override
    public Animale addAnimale(Animale a) {
        return animali_repo.save(a);
    }

    @Override
    public void deleteAnimale(int id) {
        visitaRepo.deleteByAnimaleId(id);
        diarioRepo.deleteByAnimaleId(id);
        animali_repo.deleteById(id);
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






