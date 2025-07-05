package com.catarsi.Rifugio_Animali.controller;


import com.catarsi.Rifugio_Animali.model.Adozione;
import com.catarsi.Rifugio_Animali.model.Animale;
import com.catarsi.Rifugio_Animali.model.Donazione;
import com.catarsi.Rifugio_Animali.model.Utente;
import com.catarsi.Rifugio_Animali.repos.RifugioRepoAdozione;
import com.catarsi.Rifugio_Animali.services.RifugioServiceAdozione;
import com.catarsi.Rifugio_Animali.services.RifugioServiceAnimali;
import com.catarsi.Rifugio_Animali.services.RifugioServiceUtente;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RifugioAdozioniMVC {

    @Autowired
    private RifugioRepoAdozione repoAdozione;

    @Autowired
    private RifugioServiceUtente rifugioServiceUtente;

    @Autowired
    private RifugioServiceAdozione srvAdozione;

    @Autowired
    private RifugioServiceAnimali srvAnimale;


    public RifugioAdozioniMVC(RifugioRepoAdozione repoAdozione) {
        this.repoAdozione = repoAdozione;
    }

    @GetMapping("/adozione")
    public String addAdozione(Model m) {
        m.addAttribute("adozioni", srvAdozione.getAdozioni());
        return "adozioni";
    }


    @GetMapping("/backoffice/adozioni")
    public String backofficeAdozioni(Model m) {
        m.addAttribute("adozioni", srvAdozione.getAdozioni());
        return "backofficeAdozioni";
    }



    //     @GetMapping("/backoffice/adozioni/add")
    // public String showForm(Model model) {
    //     model.addAttribute("adozione", new Adozione());
    //     return "backofficeAdozioni"; 
    // }

    @GetMapping("/adozioni/visualizza")
    public String visualizzaAnimaliAdozione(Model m) {
    m.addAttribute("animali", srvAnimale.getAnimali());
    return "visualizzaAnimaliAdozione"; 
    }

    @GetMapping("/adozioni/form")
    public String mostraFormAdozione(Model model, Principal principal, @RequestParam Integer idAnimale) {
    if (principal != null) {
        Utente utente = rifugioServiceUtente.findByEmail(principal.getName());
        model.addAttribute("utenteLoggato", utente);
    }
    Animale animale = srvAnimale.getAnimaleByIdAnimale(idAnimale);
    model.addAttribute("animaleSelezionato", animale);
    return "formAdozioni";
    }

    @PostMapping("/adozioni/add")
    public String processForm(@ModelAttribute Adozione adozione, Principal principal) {

        if (principal != null) {
            Utente utente = rifugioServiceUtente.findByEmail(principal.getName());
            adozione.setUtente(utente);
        }

        srvAdozione.addAdozione(adozione);
        return "redirect:/";
    }

        @GetMapping("/adozioni/add")
        public String showForm(Model model) {
            model.addAttribute("adozione", new Adozione());
            return "formAdozioni";
        }



        
}





