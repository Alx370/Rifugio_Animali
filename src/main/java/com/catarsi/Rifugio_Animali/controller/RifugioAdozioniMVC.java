package com.catarsi.Rifugio_Animali.controller;

import com.catarsi.Rifugio_Animali.model.Adozione;
import com.catarsi.Rifugio_Animali.model.Animale;
import com.catarsi.Rifugio_Animali.model.Utente;
import com.catarsi.Rifugio_Animali.repos.RifugioRepoAdozione;
import com.catarsi.Rifugio_Animali.services.RifugioServiceAdozione;
import com.catarsi.Rifugio_Animali.services.RifugioServiceAnimali;
import com.catarsi.Rifugio_Animali.services.RifugioServiceUtente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

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

    @GetMapping("/backoffice/adozione")
    public String backofficeAdozione(Model m) {
        m.addAttribute("adozioni", srvAdozione.getAdozioni());
        return "backofficeVistaAdozioni";
    }

    @GetMapping("/backoffice/adottati")
    public String backofficeAdottati(Model m) {
        m.addAttribute("adozione", srvAdozione.getAdozioni());
        return "backofficeVistaAdottati";
    }

    @GetMapping("/backoffice/adozioni/add")
    public String showForm(Model model) {
        model.addAttribute("adozione", new Adozione());
        return "formAdozioni";
    }

    @PostMapping("/backoffice/adozioni/add")
    public String processForm(@ModelAttribute Adozione adozione) {
        srvAdozione.addAdozione(adozione);
        return "redirect:/backoffice/adozione";
    }

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

    @GetMapping("/backoffice/adozioni/edit/{id}")
    public String modificaAdozione(@PathVariable("id") int id, Model m) {
        Adozione adozione = srvAdozione.getAdozioneById(id);
        m.addAttribute("adozione", adozione);
        m.addAttribute("animali", srvAnimale.getAnimali());
        return "formUpdateAdozioni";
    }

    @PostMapping("/backoffice/adozioni/update/{id}")
    public String updateAdozione(@PathVariable("id") int id, @ModelAttribute("adozione") Adozione aggiornata) {
        Adozione esistente = srvAdozione.getAdozioneById(id);
        esistente.setData_adozione(aggiornata.getData_adozione());
        esistente.setAnimale(aggiornata.getAnimale());
        srvAdozione.addAdozione(esistente);
        return "redirect:/backoffice/adozione";
    }
}
