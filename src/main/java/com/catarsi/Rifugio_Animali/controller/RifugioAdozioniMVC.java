package com.catarsi.Rifugio_Animali.controller;

import com.catarsi.Rifugio_Animali.model.*;
import com.catarsi.Rifugio_Animali.repos.RifugioRepoAdozione;
import com.catarsi.Rifugio_Animali.services.RifugioServiceAdozione;
import com.catarsi.Rifugio_Animali.services.RifugioServiceAnimali;
import com.catarsi.Rifugio_Animali.services.RifugioServiceUtente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Date;

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

    @Autowired
    private RifugioServiceUtente srvUtente;

    public RifugioAdozioniMVC(RifugioRepoAdozione repoAdozione) {
        this.repoAdozione = repoAdozione;
    }

    @GetMapping("/backoffice/adozioni")
    public String backofficeAdozioni(Model m) {
        m.addAttribute("adozioni", srvAdozione.getAdozioni());
        return "backofficeVistaAdozioni";
    }

    @GetMapping("/backoffice/adottati")
    public String backofficeAdottati(Model m) {
        m.addAttribute("adozione", srvAdozione.getAdozioni());
        return "backofficeVistaAdottati";
    }

    @GetMapping("/backoffice/form/aggiungiAdozione")
    public String addAdozione( Model model) {
        model.addAttribute("adozione", new Adoption());
        model.addAttribute("animali", srvAnimale.getAnimali());
        model.addAttribute("utenti", srvUtente.getUtenti());
        return "backofficeAggiungiAdozione";
    }


    @PostMapping("/backoffice/aggiungiAdozione")
    public String formAdozione(@ModelAttribute Adoption adoption) {
        srvAdozione.aggiungiDataAdozione(adoption);
        return "redirect:/backoffice/adozioni";
    }



    @GetMapping("/backoffice/adozioni/add")
    public String showForm(@RequestParam int idAnimale, Model model) {
        Animal animal = srvAnimale.getAnimaleByIdAnimale(idAnimale);
        model.addAttribute("adozione", new Adoption());
        model.addAttribute("animaleSelezionato", animal);
        return "formAdozioni";
    }

    @PostMapping("/backoffice/adozioni/add")
    public String processForm(@ModelAttribute Adoption adoption, @RequestParam int idAnimale, @RequestParam int idUtente) {
        Animal animal = srvAnimale.getAnimaleByIdAnimale(idAnimale);
        User user = srvUtente.getById(idUtente);
        adoption.setAnimale(animal);
        adoption.setUtente(user);
        adoption.setData_adozione(new Date());
        animal.setData_adozione(new Date());
        srvAdozione.addAdozione(adoption);
        return "redirect:/adozioni/visualizza";
    }

    @GetMapping("/adozioni/visualizza")
    public String visualizzaAnimaliAdozione(Model m) {
        m.addAttribute("animali", srvAnimale.getAnimali());
        return "visualizzaAnimaliAdozione";
    }

    @GetMapping("/adozioni/form")
public String mostraFormAdozione(Model model, Principal principal, @RequestParam Integer idAnimale) {
    if (principal == null) {
        return "errore_richiesta_login"; // utente non loggato
    }


    User user = rifugioServiceUtente.findByEmail(principal.getName());
    if (user == null) {
        return "errore_richiesta_login"; // utente non trovato (caso raro)
    }


    Animal animal = srvAnimale.getAnimaleByIdAnimale(idAnimale);
    model.addAttribute("utenteLoggato", user);
    model.addAttribute("animaleSelezionato", animal);
    model.addAttribute("adozione", new Adoption());


    return "formAdozioni";
}


    @GetMapping("/backoffice/adozioni/edit/{id}")
    public String modificaAdozione(@PathVariable("id") int id, Model m) {
        Adoption adoption = srvAdozione.getAdozioneById(id);
        m.addAttribute("adozione", adoption);
        m.addAttribute("animali", srvAnimale.getAnimali());
        return "formUpdateAdozioni";
    }

    @PostMapping("/backoffice/adozioni/update/{id}")
    public String updateAdozione(@PathVariable("id") int id, @ModelAttribute("adozione") Adoption aggiornata) {
        Adoption esistente = srvAdozione.getAdozioneById(id);
        esistente.setData_adozione(aggiornata.getData_adozione());
        esistente.setAnimale(aggiornata.getAnimale());
        srvAdozione.addAdozione(esistente);
        return "redirect:/backoffice/adozioni";
    }
}
