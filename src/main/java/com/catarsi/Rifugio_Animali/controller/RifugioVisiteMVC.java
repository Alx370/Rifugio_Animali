package com.catarsi.Rifugio_Animali.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.catarsi.Rifugio_Animali.model.Visita;
import com.catarsi.Rifugio_Animali.services.RifugioServiceAnimali;
import com.catarsi.Rifugio_Animali.services.RifugioServiceAnimaliImpl;
import com.catarsi.Rifugio_Animali.services.RifugioServiceDottoreImpl;
import com.catarsi.Rifugio_Animali.services.RifugioServicesVisitaImpl;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@Controller
@RequestMapping("visite-veterinarie") //è la richiesta del link, quando scrivi /visite-veterinarie finisci su questo controller
public class RifugioVisiteMVC {
    @Autowired
    private RifugioServicesVisitaImpl srvVisite;
    @Autowired
    private RifugioServiceAnimaliImpl srvAnimali;
    @Autowired
    private RifugioServiceDottoreImpl srvDottori;
    // @GetMapping("/")
    // public String getVisite(Model m) {
    //     m.addAttribute("visite",srvVisite.getVisite());
    //     return "Visite"; //ritorna una Stringa(i nomi dei templates)
    // }

    @GetMapping({"", "/"})
    public String getVisite(Model m) {
        m.addAttribute("visite",srvVisite.getAll());
        return "Visite"; //ritorna una Stringa(i nomi dei templates)
    }



    @GetMapping("/nuova-visita")
    public String showFormVisita(Model model) {
        model.addAttribute("animali", srvAnimali.getAnimali());
        model.addAttribute("dottori", srvDottori.getDottori()); // <-- aggiungi questo se hai un servizio dottori
        model.addAttribute("visita", new Visita());
        return "aggiungiVisita";
    }

    @PostMapping("/nuova-visita")
    public String salvaVisita(Visita visita) {
        srvVisite.salvaVisita(visita); // Assicurati che esista questo metodo
        return "redirect:/visite-veterinarie/";
    }

    //Per leggere i dati si usa GET, per creare e inviare POST, per eliminare DELETE, per modificare PUT
    @DeleteMapping("/{id}") 
    public String eliminaVisite(@PathVariable int id) { //qualsiasi cosa gli metti nelle graffe poi te lo salva come Id
        srvVisite.eliminaVisitePerId(id); // Usa il metodo corretto del servizio
        return "redirect:/visite-veterinarie";
    }

    // @PutMapping("/{id}") 
    // public String modificaVisita(@PathVariable int id){
        
    // }

    //modifica in due parti prima vai nella pagina di modifica
    // @GetMapping("/{id}/modifica")
    // public String showModificaForm(@PathVariable int id, Model m){
    //     Visita v=srvVisite.getById(id);
    //     m.addAttribute("animali", srvAnimali.getAnimali());
    //     m.addAttribute("dottori", srvDottori.getDottori()); 
    //     m.addAttribute("visita",v); //passo due argomenti il primo nome dell'attributo e il secondo il valore associato all'attributo
    //     return "modificaVisita";
    // }
    


    



   
    

}
