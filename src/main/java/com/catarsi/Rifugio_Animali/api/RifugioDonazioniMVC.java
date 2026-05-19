package com.catarsi.Rifugio_Animali.api;


import java.security.Principal;

import com.catarsi.Rifugio_Animali.business.model.Donation;
import com.catarsi.Rifugio_Animali.business.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.catarsi.Rifugio_Animali.business.repos.RifugioRepoDonazione;
import com.catarsi.Rifugio_Animali.business.services.impl.RifugioServiceDonazioneImpl;
import com.catarsi.Rifugio_Animali.business.services.RifugioServiceUtente;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


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


    User user = rifugioServiceUtente.findByEmail(principal.getName());
    if (user == null) {
        return "errore_richiesta_login";
    }


    model.addAttribute("utenteLoggato", user);
    model.addAttribute("donazione", new Donation()); // prepara anche l’oggetto donazione
    return "formDonazioni";
}



    @PostMapping("/donazioni/add")
public String processForm(@ModelAttribute Donation donation, Principal principal) {

    if (principal != null) {
        User user = rifugioServiceUtente.findByEmail(principal.getName());
        donation.setUtente(user);
    }

    srvDonazione.addDonazione(donation);
    return "redirect:/";
}


        @GetMapping("/donazioni/add")
    public String showForm(Model model) {
        model.addAttribute("donazione", new Donation());
        return "formDonazioni"; 
    }



    
    @GetMapping("/backoffice/donazioni")
    public String backofficeDonazioni(Model m) {
        m.addAttribute("donazioni", srvDonazione.getDonazioni());
        return "backofficeDonazioni";
    }
    
}