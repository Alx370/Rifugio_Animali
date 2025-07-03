package com.catarsi.Rifugio_Animali.services;

import com.catarsi.Rifugio_Animali.model.Utente;
import com.catarsi.Rifugio_Animali.repos.RifugioRepoUtente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class RifugioServiceUtenteImpl implements UserDetailsService{

    @Autowired
    private RifugioRepoUtente utente_repo;

    @Override //sovrascrizione di un metodo esistente dall'interfaccia ,implements per le interfacce, extends per le classi
    public UserDetails loadUserByUsername(String email) {
        Utente user = utente_repo.findByEmail(email)
                        .orElseThrow(()->new UsernameNotFoundException("User not found"));
        return org.springframework.security.core.userdetails.User
            .withUsername(user.getEmail())
            .password(user.getPassword())
            .roles("USER")
            .build();
    }
    



}
