package com.catarsi.Rifugio_Animali.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class Rifhomecontrollersignin {
    @GetMapping("/")
    public String home() {
        return "index"; // carica src/main/resources/templates/index.html (Thymeleaf)
    }
}
