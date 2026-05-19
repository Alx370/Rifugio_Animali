package com.catarsi.Rifugio_Animali.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller  // annotazione qui
public class RifugioHomeControllerMVC {

    @GetMapping("/")
    public String home() {
        return "home"; // cerca templates/index.html e lo renderizza con Thymeleaf
    }

    // @GetMapping("/gest")
    // public String homeGest() {
    //     return "homeGest"; 
    // }
}
