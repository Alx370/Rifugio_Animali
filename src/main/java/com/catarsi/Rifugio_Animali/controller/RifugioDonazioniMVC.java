package com.catarsi.Rifugio_Animali.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.catarsi.Rifugio_Animali.repos.RifugioRepoDonazione;
import com.catarsi.Rifugio_Animali.services.RifugioServiceDonazioneImpl;


import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class RifugioDonazioniMVC {
    
    private final RifugioRepoDonazione repoDonazione;

    @Autowired
    private RifugioServiceDonazioneImpl srvDonazione;

    public RifugioDonazioniMVC(RifugioRepoDonazione repoDonazione){
        this.repoDonazione = repoDonazione;
    }

    @GetMapping("/donazioni")
    public String addDonazioni(Model m) {
        m.addAttribute("donazioni", srvDonazione.getDonazioni());
        return "donazioni";
    }
    
}

