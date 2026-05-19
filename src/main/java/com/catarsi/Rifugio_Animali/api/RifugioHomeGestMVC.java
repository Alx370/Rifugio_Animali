package com.catarsi.Rifugio_Animali.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.catarsi.Rifugio_Animali.business.services.impl.AdoptionServiceImpl;
import com.catarsi.Rifugio_Animali.business.services.impl.AnimalServiceImpl;
import com.catarsi.Rifugio_Animali.business.services.impl.RifugioServiceDonazioneImpl;
import com.catarsi.Rifugio_Animali.business.services.impl.RifugioServiceDottoreImpl;
import com.catarsi.Rifugio_Animali.business.services.impl.RifugioServiceEnteImpl;
import com.catarsi.Rifugio_Animali.business.services.impl.RifugioServiceUtenteImpl;
import com.catarsi.Rifugio_Animali.business.services.impl.RifugioServicesVisitaImpl;

@Controller
public class RifugioHomeGestMVC {
    

    @Autowired
    private AnimalServiceImpl srvAnimale;

    @Autowired
    private AdoptionServiceImpl srvAdozione;

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
