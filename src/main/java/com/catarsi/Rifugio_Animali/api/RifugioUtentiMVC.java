package com.catarsi.Rifugio_Animali.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.catarsi.Rifugio_Animali.business.repos.RifugioRepoUtente;
import com.catarsi.Rifugio_Animali.business.services.impl.RifugioServiceUtenteImpl;

import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class RifugioUtentiMVC {
    
    private final RifugioRepoUtente repoUtente;

    @Autowired
    private RifugioServiceUtenteImpl srvUtente;

    public RifugioUtentiMVC(RifugioRepoUtente repoUtente){
        this.repoUtente = repoUtente;
    }


    @GetMapping ("/login") //ogni volta che sul link scrivi login e la richiesta è di tipo get esegui il meotodo sotto
    public String login(){
        return "login";
    }

    @GetMapping("/backoffice/utenti")
    public String backofficeUtenti(Model m) {
        m.addAttribute("utenti", srvUtente.getUtenti());
        return "backofficeUtenti";
    }


    
}

    
    




