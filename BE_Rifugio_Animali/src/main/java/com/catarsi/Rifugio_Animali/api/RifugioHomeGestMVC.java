package com.catarsi.Rifugio_Animali.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.catarsi.Rifugio_Animali.business.services.impl.AdoptionServiceImpl;
import com.catarsi.Rifugio_Animali.business.services.impl.AnimalServiceImpl;
import com.catarsi.Rifugio_Animali.business.services.impl.DonationServiceImpl;
import com.catarsi.Rifugio_Animali.business.services.impl.VeterinarianServiceImpl;
import com.catarsi.Rifugio_Animali.business.services.impl.OrganizationServiceImpl;
import com.catarsi.Rifugio_Animali.business.services.impl.UserServiceImpl;
import com.catarsi.Rifugio_Animali.business.services.impl.VisitServiceImpl;

@Controller
public class RifugioHomeGestMVC {
    

    @Autowired
    private AnimalServiceImpl srvAnimale;

    @Autowired
    private AdoptionServiceImpl srvAdozione;

    @Autowired
    private DonationServiceImpl srvDonazione;

    @Autowired
    private VisitServiceImpl srvVisita;

    @Autowired
    private VeterinarianServiceImpl srvDottore;

    @Autowired
    private UserServiceImpl srvUtente;

    @Autowired
    private OrganizationServiceImpl srvEnte;


    @GetMapping("/gest")
    public String mostraGest(Model m) {
        m.addAttribute("animaliCount", srvAnimale.getAnimali().size());
        m.addAttribute("adozioniCount", srvAdozione.getAdozioni().size());
        m.addAttribute("donazioniTotali", srvDonazione.totalDonations());
        // m.addAttribute("visiteOggi", srvVisita.countVisiteOggi());
        m.addAttribute("dottoriCount", srvDottore.findAllVeterinarians().size());
        m.addAttribute("utentiCount", srvUtente.findAllUsers().size());
        m.addAttribute("entiCount", srvEnte.findAllOrganizations().size());
        return "homeGest"; 
    }
}
