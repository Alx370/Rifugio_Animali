package com.catarsi.Rifugio_Animali.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.catarsi.Rifugio_Animali.repos.RifugioRepoAdozione;
import com.catarsi.Rifugio_Animali.repos.RifugioRepoAnimale;
import com.catarsi.Rifugio_Animali.repos.RifugioRepoDonazione;
import com.catarsi.Rifugio_Animali.repos.RifugioRepoDottore;
import com.catarsi.Rifugio_Animali.repos.RifugioRepoEnte;
import com.catarsi.Rifugio_Animali.repos.RifugioRepoUtente;
import com.catarsi.Rifugio_Animali.repos.RifugioRepoVisita;
import com.catarsi.Rifugio_Animali.services.RifugioServiceAdozioneImpl;
import com.catarsi.Rifugio_Animali.services.RifugioServiceAnimaliImpl;
import com.catarsi.Rifugio_Animali.services.RifugioServiceDonazioneImpl;
import com.catarsi.Rifugio_Animali.services.RifugioServiceDottoreImpl;
import com.catarsi.Rifugio_Animali.services.RifugioServiceEnteImpl;
import com.catarsi.Rifugio_Animali.services.RifugioServiceUtenteImpl;
import com.catarsi.Rifugio_Animali.services.RifugioServicesVisitaImpl;

@Controller
public class RifugioHomeGestMVC {
    

    @Autowired
    private RifugioServiceAnimaliImpl srvAnimale;

    @Autowired
    private RifugioServiceAdozioneImpl srvAdozione;

    @Autowired
    private RifugioServiceDonazioneImpl srvDonazione;

    @Autowired
    private RifugioServicesVisitaImpl srvVisita;

    @Autowired
    private RifugioServiceDottoreImpl srvDottore;

    @Autowired
    private RifugioServiceUtenteImpl srvUtente;

    @Autowired
    private RifugioServiceEnteImpl srvEnte;


    @GetMapping("/gest")
    public String mostraGest(Model m) {
        m.addAttribute("animaliCount", srvAnimale.getAnimali().size());
        m.addAttribute("adozioniCount", srvAdozione.getAdozioni().size());
        m.addAttribute("donazioniTotali", srvDonazione.sommaDonazioni());
        // m.addAttribute("visiteOggi", srvVisita.countVisiteOggi());
        m.addAttribute("dottoriCount", srvDottore.getDottori().size());
        m.addAttribute("utentiCount", srvUtente.getUtenti().size());
        m.addAttribute("entiCount", srvEnte.getAllEnti().size());
        return "homeGest"; 
    }
}
