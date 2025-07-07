package com.catarsi.Rifugio_Animali.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BackofficeEntiController {

    @GetMapping("/backoffice_enti_vista")
    public String viewEnti() {
        return "backoffice_enti_vista";  // Thymeleaf cerca backoffice_enti_vista.html in resources/templates
    }

    @GetMapping("/backoffice_enti_aggiungi")
    public String addEnti() {
        return "backoffice_enti_aggiungi";
    }

    @GetMapping("/backoffice_enti_update")
    public String updateEnti() {
        return "backoffice_enti_update";
    }

    @GetMapping("/backoffice_enti_delete")
    public String deleteEnti() {
        return "backoffice_enti_delete";
    }
}
