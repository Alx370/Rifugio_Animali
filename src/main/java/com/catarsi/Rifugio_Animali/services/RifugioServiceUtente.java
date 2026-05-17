package com.catarsi.Rifugio_Animali.services;

import com.catarsi.Rifugio_Animali.model.User;
import java.util.List;

public interface RifugioServiceUtente {

    // salva (aggiunge o aggiorna) un utente
    User save(User u);

    // restituisce tutti gli utenti
    List<User> getAll();

    // recupera un utente per id
    User getById(Integer id);

    // elimina un utente per id
    void delete(Integer id);

    User findByEmail(String name);

    List <User> getUtenti();
}
