package com.catarsi.Rifugio_Animali.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.catarsi.Rifugio_Animali.model.Visit;
import com.catarsi.Rifugio_Animali.services.RifugioServiceAnimaliImpl;
import com.catarsi.Rifugio_Animali.services.RifugioServiceDottoreImpl;
import com.catarsi.Rifugio_Animali.services.RifugioServicesVisitaImpl;


@Controller
@RequestMapping("visite-veterinarie") //è la richiesta del link, quando scrivi /visite-veterinarie finisci su questo controller
public class RifugioVisiteMVC {
    @Autowired
    private RifugioServicesVisitaImpl srvVisite;
    @Autowired
    private RifugioServiceAnimaliImpl srvAnimali;
    @Autowired
    private RifugioServiceDottoreImpl srvDottori;

    @GetMapping({"", "/"})
    public String getVisite(Model m) {
        m.addAttribute("visite",srvVisite.getAll());
        return "backofficeVistaVisite";
    }

    @GetMapping("/nuova-visita")
    public String showFormVisita(Model model) {
        model.addAttribute("animali", srvAnimali.getAnimali());
        model.addAttribute("dottori", srvDottori.getDottori());
        model.addAttribute("visita", new Visit());
        return "backofficeAggiungiVisita";
    }

    @PostMapping("/nuova-visita")
    public String salvaVisita(Visit visit) {
        srvVisite.salvaVisita(visit); // Assicurati che esista questo metodo
        return "redirect:/visite-veterinarie/";
    }

    //Per leggere i dati si usa GET, per creare e inviare POST, per eliminare DELETE, per modificare PUT
    @DeleteMapping("/{id}") 
    public String eliminaVisite(@PathVariable int id) { //qualsiasi cosa gli metti nelle graffe poi te lo salva come Id
        srvVisite.eliminaVisitePerId(id); // Usa il metodo corretto del servizio
        return "redirect:/visite-veterinarie";
    }
    // modifica in due parti prima vai nella pagina di modifica
    @GetMapping("/{id}/modifica")
    public String showModificaForm(@PathVariable int id, Model m){
        Visit v=srvVisite.getById(id);
        m.addAttribute("animali", srvAnimali.getAnimali());
        m.addAttribute("dottori", srvDottori.getDottori());
        m.addAttribute("visita",v); //passo due argomenti il primo nome dell'attributo e il secondo il valore associato all'attributo
        return "backofficeUpdateVisita";
    }

    @PutMapping("/{id}")
    public String modificaVisita(@PathVariable int id, @ModelAttribute("visita") Visit visitAggiornata) {
        Visit visitEsistente = srvVisite.getById(id);

        visitEsistente.setData_visita(visitAggiornata.getData_visita());
        visitEsistente.setDescrizione(visitAggiornata.getDescrizione());
        visitEsistente.setAnimale(visitAggiornata.getAnimale());
        visitEsistente.setDottore(visitAggiornata.getDottore());

        srvVisite.save(visitEsistente);
        return "redirect:/visite-veterinarie";
    }


    


    



   
    

}
