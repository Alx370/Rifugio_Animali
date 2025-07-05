package com.catarsi.Rifugio_Animali.services;

import com.catarsi.Rifugio_Animali.model.Utente;
import java.util.List;

public interface RifugioServiceUtente {

    // salva (aggiunge o aggiorna) un utente
    Utente save(Utente u);

    // restituisce tutti gli utenti
    List<Utente> getAll();

    // recupera un utente per id
    Utente getById(Integer id);

    // elimina un utente per id
    void delete(Integer id);

    Utente findByEmail(String name);

    List <Utente> getUtenti();
}
