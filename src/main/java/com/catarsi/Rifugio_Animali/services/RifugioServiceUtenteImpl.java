package com.catarsi.Rifugio_Animali.services;

import com.catarsi.Rifugio_Animali.model.Utente;
import com.catarsi.Rifugio_Animali.repos.RifugioRepoUtente;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class RifugioServiceUtenteImpl implements RifugioServiceUtente, UserDetailsService {

    @Autowired
    private RifugioRepoUtente utente_repo;

    // Metodo per autenticazione (Spring Security)
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Utente user = utente_repo.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Utente non trovato con email: " + email));
        
        return org.springframework.security.core.userdetails.User
                .withUsername(user.getEmail())
                .password(user.getPassword())
                .roles("USER") // puoi cambiare in base al ruolo reale
                .build();
    }

    // Salva o aggiorna un utente
    @Override
    public Utente save(Utente u) {
        return utente_repo.save(u);
    }

    // Recupera tutti gli utenti
    @Override
    public List<Utente> getAll() {
        return utente_repo.findAll();
    }

    // Recupera un utente per ID
    @Override
    public Utente getById(Integer id) {
        return utente_repo.findById(id).orElse(null);
    }

    // Elimina un utente per ID
    @Override
    public void delete(Integer id) {
        utente_repo.deleteById(id);
    }

    @Override
    public Utente findByEmail(String email) {
        return utente_repo.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Utente non trovato con email: " + email));
    }

    @Override
    public List <Utente> getUtenti() {
        return utente_repo.findAll();
    }


}
