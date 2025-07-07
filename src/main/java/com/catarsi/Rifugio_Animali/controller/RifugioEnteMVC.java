package com.catarsi.Rifugio_Animali.controller;

import com.catarsi.Rifugio_Animali.services.RifugioServiceEnte;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/backoffice/enti")
public class RifugioEnteMVC {

    @Autowired
    private RifugioServiceEnte service;

    @GetMapping("/vista")
    public String viewEnti() {
        return "backoffice_enti_vista";
    }

    @GetMapping("/aggiungi")
    public String addEnti() {
        return "backoffice_enti_aggiungi";
    }

    @GetMapping("/update")
    public String updateEnti() {
        return "backoffice_enti_update";
    }

    @GetMapping("/delete")
    public String deleteEnti() {
        return "backoffice_enti_delete";
    }

    // POST per eliminazione ente via form HTML
    @PostMapping("/delete")
    public String deleteEntita(@RequestParam("id") Integer id, Model model) {
        try {
            service.delete(id);
            model.addAttribute("msg", "Ente con ID " + id + " eliminato correttamente.");
        } catch (Exception e) {
            model.addAttribute("msg", "Errore durante l'eliminazione: " + e.getMessage());
        }
        return "backoffice_enti_delete";
    }
}
