package com.catarsi.Rifugio_Animali.api;

import com.catarsi.Rifugio_Animali.business.model.Organization;
import com.catarsi.Rifugio_Animali.business.services.RifugioServiceEnte;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/backoffice/enti")
public class RifugioEnteMVC {

    private final RifugioServiceEnte service;

    public RifugioEnteMVC(RifugioServiceEnte service) {
        this.service = service;
    }

    @GetMapping
    public String listaEnti(Model model) {
        List<Organization> enti = service.getAllEnti();
        model.addAttribute("enti", enti);
        return "backofficeVistaEnti";
    }

    @GetMapping("/aggiungi")
    public String formAggiunta(Model model) {
        model.addAttribute("ente", new Organization());
        return "backofficeAggiungiEnte";
    }

    @PostMapping("/aggiungi")
    public String processaAggiunta(@ModelAttribute Organization organization) {
        service.addEnte(organization);
        return "redirect:/backoffice/enti";
    }

    @GetMapping("/modifica/{id}")
    public String formModifica(@PathVariable("id") int id, Model model) {
        Organization organization = service.getEnteById(id);
        model.addAttribute("ente", organization);
        return "backofficeUpdateEnti";
    }

    @PostMapping("/modifica/{id}")
    public String processaModifica(@PathVariable("id") int id, @ModelAttribute Organization aggiornato) {
        Organization esistente = service.getEnteById(id);
        esistente.setNome(aggiornato.getNome());
        esistente.setEmail(aggiornato.getEmail());
        esistente.setTelefono(aggiornato.getTelefono());
        service.addEnte(esistente);
        return "redirect:/backoffice/enti";
    }

    @GetMapping("/elimina/{id}")
    public String eliminaEnte(@PathVariable("id") int id) {
        service.delete(id);
        return "redirect:/backoffice/enti";
    }
}
