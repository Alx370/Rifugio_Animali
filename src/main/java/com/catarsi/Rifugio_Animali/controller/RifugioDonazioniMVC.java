package com.catarsi.Rifugio_Animali.controller;

import com.catarsi.Rifugio_Animali.model.Donazione;
import com.catarsi.Rifugio_Animali.repos.RifugioRepoDonazione;
import com.catarsi.Rifugio_Animali.services.RifugioServiceDonazioneImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class RifugioDonazioniMVC {

    private final RifugioRepoDonazione repoDonazione;

    @Autowired
    private RifugioServiceDonazioneImpl srvDonazione;

    public RifugioDonazioniMVC(RifugioRepoDonazione repoDonazione) {
        this.repoDonazione = repoDonazione;
    }

    // Mostra tutte le donazioni
    @GetMapping("/donazioni")
    public String listDonazioni(Model m) {
        m.addAttribute("donazioni", srvDonazione.getDonazioni());
        return "donazioni"; // nome della pagina HTML
    }

    // ✅ Mostra il form per creare nuova donazione
    @GetMapping("/donazioni/nuova")
    public String showForm(Model model) {
        model.addAttribute("donazione", new Donazione()); // oggetto vuoto
        return "form_donazione"; // nome del template HTML da creare
    }

    // ✅ Salva nuova donazione (POST dal form)
    @PostMapping("/donazioni")
    public String salvaDonazione(@ModelAttribute Donazione donazione) {
        srvDonazione.addDonazione(donazione);
        return "redirect:/donazioni"; // dopo il salvataggio torna alla lista
    }
}
