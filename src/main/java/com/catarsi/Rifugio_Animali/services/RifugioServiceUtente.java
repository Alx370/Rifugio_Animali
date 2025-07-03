package com.catarsi.Rifugio_Animali.services;

import com.catarsi.Rifugio_Animali.model.Utente;

import java.util.List;

public interface RifugioServiceUtente {

    Utente addUtente(Utente u);
    List<Utente> getUtenti();

    Utente findByEmail(String email);
}
