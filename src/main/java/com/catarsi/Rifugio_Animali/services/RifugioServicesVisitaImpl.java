package com.catarsi.Rifugio_Animali.services;

import com.catarsi.Rifugio_Animali.model.Visit;
import com.catarsi.Rifugio_Animali.repos.RifugioRepoVisita;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class RifugioServicesVisitaImpl implements RifugioServicesVisita {

    @Autowired
    private RifugioRepoVisita visitaRepo;

    @Override
    public Visit save(Visit v) {
        return visitaRepo.save(v);
    }

    @Override
    public List<Visit> getAll() {
        return visitaRepo.findAll();
    }

    @Override
    public Visit getById(int id) {
        return visitaRepo.findById(id).orElse(null);
    }

    @Override
    public void delete(int id) {
        visitaRepo.deleteById(id);
    }

    @Override
    public Date getDataVisita(int id) {
        Visit visit = visitaRepo.findById(id).orElse(null);
        return (visit != null) ? visit.getData_visita() : null;
    }

    public Visit salvaVisita(Visit v){
        return visitaRepo.save(v);
    }

    //mi serve il metodo eliminaVisitePerId perchè lo chiamo nel controller 
    public void eliminaVisitePerId(int idVisita) {
        visitaRepo.deleteById(idVisita); // Usa deleteById fornito da JpaRepository
    }

}
