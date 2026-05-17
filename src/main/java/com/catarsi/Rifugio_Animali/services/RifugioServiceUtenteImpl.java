package com.catarsi.Rifugio_Animali.services;

import com.catarsi.Rifugio_Animali.model.User;
import com.catarsi.Rifugio_Animali.repos.RifugioRepoUtente;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class RifugioServiceUtenteImpl implements RifugioServiceUtente {

    @Autowired
    private RifugioRepoUtente utente_repo;

    // Salva o aggiorna un utente
    @Override
    public User save(User u) {
        return utente_repo.save(u);
    }

    // Recupera tutti gli utenti
    @Override
    public List<User> getAll() {
        return utente_repo.findAll();
    }

    // Recupera un utente per ID
    @Override
    public User getById(Integer id) {
        return utente_repo.findById(id).orElse(null);
    }

    // Elimina un utente per ID
    @Override
    public void delete(Integer id) {
        utente_repo.deleteById(id);
    }

    @Override
    public User findByEmail(String email) {
        return utente_repo.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Utente non trovato con email: " + email));
    }

    @Override
    public List <User> getUtenti() {
        return utente_repo.findAll();
    }


}
