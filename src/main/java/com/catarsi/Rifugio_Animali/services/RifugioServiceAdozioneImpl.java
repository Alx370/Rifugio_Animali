package com.catarsi.Rifugio_Animali.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.catarsi.Rifugio_Animali.model.Adozione;
import com.catarsi.Rifugio_Animali.repos.RifugioRepoAdozione;

@Service
public class RifugioServiceAdozioneImpl implements RifugioServiceAdozione {
    
    @Autowired
    private RifugioRepoAdozione repo_adozione;

    @Override
    public Adozione addAdozione(Adozione a) {
        return repo_adozione.save(a);
    }

    @Override
    public Adozione save(Adozione a) {
        return repo_adozione.save(a); // stesso comportamento di addAdozione
    }

    @Override
    public List<Adozione> getAdozioni() {
        return repo_adozione.findAll();
    }

    @Override
    public Adozione getById(int id) {
        return repo_adozione.findById(id).orElse(null);
    }

    @Override
    public void delete(int id) {
        repo_adozione.deleteById(id);
    }
}
