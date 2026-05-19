package com.catarsi.Rifugio_Animali.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.catarsi.Rifugio_Animali.sign_in.RegistrazioneUtente;

@Controller
public class RifugioSigninMVC{

    // Mostra il form di registrazione (signin)
    @GetMapping("/signin")
    public String mostraFormRegistrazione() {
        return "signin";  // Thymeleaf cerca templates/signin.html
    }

    // Gestisce il submit del form di registrazione
    @PostMapping("/signin")
    public String registraUtente(
            @RequestParam String nome,
            @RequestParam String cognome,
            @RequestParam String email,
            @RequestParam String password,
            @RequestParam String telefono,
            @RequestParam String sesso,
            @RequestParam String dataNascita
    ) {
        // Qui metti la logica per salvare l'utente, per esempio:
        RegistrazioneUtente.registraUtente(nome, cognome, email, password, telefono, sesso, dataNascita);

        // Per ora solo redirect a pagina di successo
        return "redirect:/successo";
    }

    // Mostra pagina di successo dopo la registrazione
    @GetMapping("/successo")
    public String mostraPaginaSuccesso() {
        return "/successo";  // Thymeleaf cerca templates/successo.html
    }
}
