package com.catarsi.Rifugio_Animali.controller;


import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.catarsi.Rifugio_Animali.model.Adozione;
import com.catarsi.Rifugio_Animali.model.Animale;
import com.catarsi.Rifugio_Animali.model.Diario;
import com.catarsi.Rifugio_Animali.model.Donazione;
import com.catarsi.Rifugio_Animali.model.Utente;
import com.catarsi.Rifugio_Animali.repos.RifugioRepoDonazione;
import com.catarsi.Rifugio_Animali.services.RifugioServiceDonazioneImpl;
import com.catarsi.Rifugio_Animali.services.RifugioServiceUtente;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.catarsi.Rifugio_Animali.model.Donazione;
import com.catarsi.Rifugio_Animali.repos.RifugioRepoDonazione;
import com.catarsi.Rifugio_Animali.services.RifugioServiceDonazioneImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class RifugioDonazioniMVC {

    private final RifugioRepoDonazione repoDonazione;

    @Autowired
    private RifugioServiceDonazioneImpl srvDonazione;


    @Autowired
    private RifugioServiceUtente rifugioServiceUtente;

    public RifugioDonazioniMVC(RifugioRepoDonazione repoDonazione){
        this.repoDonazione = repoDonazione;
    }

    // Mostra tutte le donazioni
    @GetMapping("/donazioni")
    public String listDonazioni(Model m) {
        m.addAttribute("donazioni", srvDonazione.getDonazioni());
        return "donazioni"; 
    }
    
  @GetMapping("/donazioni/form")
public String mostraFormDonazione(Model model, Principal principal) {
    if (principal == null) {
        return "errore_richiesta_login"; // utente non loggato, reindirizza alla pagina errore
    }


    Utente utente = rifugioServiceUtente.findByEmail(principal.getName());
    if (utente == null) {
        return "errore_richiesta_login";
    }


    model.addAttribute("utenteLoggato", utente);
    model.addAttribute("donazione", new Donazione()); // prepara anche l’oggetto donazione
    return "formDonazioni";
}



    @PostMapping("/donazioni/add")
public String processForm(@ModelAttribute Donazione donazione, Principal principal) {

    if (principal != null) {
        Utente utente = rifugioServiceUtente.findByEmail(principal.getName());
        donazione.setUtente(utente); 
    }

    srvDonazione.addDonazione(donazione); 
    return "redirect:/";
}


        @GetMapping("/donazioni/add")
    public String showForm(Model model) {
        model.addAttribute("donazione", new Donazione());
        return "formDonazioni"; 
    }



    
    @GetMapping("/backoffice/donazioni")
    public String backofficeDonazioni(Model m) {
        m.addAttribute("donazioni", srvDonazione.getDonazioni());
        return "backofficeDonazioni";
    }
    
}