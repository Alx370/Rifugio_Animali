package com.catarsi.Rifugio_Animali.services;

import com.catarsi.Rifugio_Animali.model.Utente;
import com.catarsi.Rifugio_Animali.repos.RifugioRepoUtente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RifugioServiceUtenteImpl implements RifugioServiceUtente{

    @Autowired
    private RifugioRepoUtente utente_repo;

    @Override
    public Utente addUtente(Utente u) {
        return utente_repo.save(u);
    }

    @Override
    public List<Utente> getUtenti() {
        return utente_repo.findAll();
    }
}
