package com.catarsi.Rifugio_Animali.services;

import java.util.List;

import com.catarsi.Rifugio_Animali.model.Adoption;
import com.catarsi.Rifugio_Animali.model.Animal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.catarsi.Rifugio_Animali.model.Animal;
import com.catarsi.Rifugio_Animali.repos.RifugioRepoAdozione;
import com.catarsi.Rifugio_Animali.repos.RifugioRepoAnimale;

@Service
public class RifugioServiceAdozioneImpl implements RifugioServiceAdozione {
    
    @Autowired
    private RifugioRepoAdozione repo_adozione;

    @Autowired
    private RifugioRepoAnimale repo_animale;


    @Override
    public Adoption addAdozione(Adoption a) {
        return repo_adozione.save(a);
    }

    @Override
    public Adoption save(Adoption a) {
        return repo_adozione.save(a); // stesso comportamento di addAdozione
    }

    @Override
    public List<Adoption> getAdozioni() {
        return repo_adozione.findAll();
    }

    // @Override
    // public Adozione getAdozionebyIdAdozione(int id) {
    //     return adozioni_repo.findById(id)
    //             .orElseThrow(() -> new RuntimeException("Adozione non trovata con ID: " + id));
    // }

    @Override
    public Adoption getAdozioneById(int id) {
        return repo_adozione.findById(id).orElse(null);
    }

    @Override
    public Adoption getById(int id) {
        return repo_adozione.findById(id).orElse(null);
    }

    @Override
    public void delete(int id) {
        repo_adozione.deleteById(id);
    }


    @Override
    public Animal aggiungiDataAdozione(Adoption a) {
    // Salva l'adozione
    repo_adozione.save(a);

    // Aggiorna l'animale con la data
    Animal animal = a.getAnimale();
    animal.setData_adozione(a.getData_adozione());

    // Salva l'animale aggiornato
    return repo_animale.save(animal);
    }

}
