package com.catarsi.Rifugio_Animali.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.catarsi.Rifugio_Animali.model.Utente;
import com.catarsi.Rifugio_Animali.repos.RifugioRepoUtente;
import com.catarsi.Rifugio_Animali.services.RifugioServiceUtenteImpl;
import com.catarsi.Rifugio_Animali.sign_in.RegistrazioneUtente;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@Controller
public class RifugioUtentiMVC {
    
    private final RifugioRepoUtente repoUtente;

    @Autowired
    private RifugioServiceUtenteImpl srvUtente;

    public RifugioUtentiMVC(RifugioRepoUtente repoUtente){
        this.repoUtente = repoUtente;
    }

    // @GetMapping("/utenti")
    // public String addUtenti(Model m) {
    //     m.addAttribute("utenti", srvUtente.getUtenti());
    //     return "utenti";
    // }
    @GetMapping ("/login") //ogni volta che sul link scrivi login e la richiesta è di tipo get esegui il meotodo sotto
    public String login(){
        return "login";
    }
    
    @GetMapping("/backoffice/adozioni/add")
public String mostraFormAdozione(Model model, Principal principal) {
    Utente utente = repoUtente.findByEmail(principal.getName())
        .orElseThrow(() -> new UsernameNotFoundException("Utente non trovato"));
    model.addAttribute("utenteLoggato", utente);
    return "formAdozioni";
}

    
}

    
    




