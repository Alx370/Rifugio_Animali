package com.catarsi.Rifugio_Animali.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller  // annotazione qui
public class RifugioHomeControllerMVC {

    @GetMapping("/")
    public String home() {
        return "index"; // cerca templates/index.html e lo renderizza con Thymeleaf
    }
}
