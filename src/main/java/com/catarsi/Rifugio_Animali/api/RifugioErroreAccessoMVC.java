package com.catarsi.Rifugio_Animali.api;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class RifugioErroreAccessoMVC {


    @GetMapping("/errore-login")
    public String mostraErroreLogin() {
        return "errore_richiesta_login"; // Nome del file HTML in /templates, senza estensione
    }
}
