package com.catarsi.Rifugio_Animali.services;

import com.catarsi.Rifugio_Animali.model.Visita;
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
    public Visita save(Visita v) {
        return visitaRepo.save(v);
    }

    @Override
    public List<Visita> getAll() {
        return visitaRepo.findAll();
    }

    @Override
    public Visita getById(int id) {
        return visitaRepo.findById(id).orElse(null);
    }

    @Override
    public void delete(int id) {
        visitaRepo.deleteById(id);
    }

    @Override
    public Date getDataVisita(int id) {
        Visita visita = visitaRepo.findById(id).orElse(null);
        return (visita != null) ? visita.getData_visita() : null;
    }

    public Visita salvaVisita(Visita v){
        return visitaRepo.save(v);
    }

@Autowired
private RifugioRepoVisita visitaRepo;

public void eliminaVisitePerId(int idVisita) {
    visitaRepo.deleteById(idVisita); // Usa deleteById fornito da JpaRepository
}

}
