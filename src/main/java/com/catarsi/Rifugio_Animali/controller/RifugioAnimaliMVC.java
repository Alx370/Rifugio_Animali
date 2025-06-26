package com.catarsi.Rifugio_Animali.controller;

import com.catarsi.Rifugio_Animali.model.Animale;
import com.catarsi.Rifugio_Animali.model.Diario;
import com.catarsi.Rifugio_Animali.repos.RifugioRepoAnimale;
import com.catarsi.Rifugio_Animali.services.RifugioServiceAnimali;
import com.catarsi.Rifugio_Animali.services.RifugioServiceDiario;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class RifugioAnimaliMVC {

    private final RifugioRepoAnimale repoAnimale;

    @Autowired
    private RifugioServiceAnimali srvAnimale;

    @Autowired
    private RifugioServiceDiario srvDiario;

    public RifugioAnimaliMVC(RifugioRepoAnimale repoAnimale) {
        this.repoAnimale = repoAnimale;
    }

    @GetMapping("/animali")
    public String addAnimali(Model m) {
        m.addAttribute("animali", srvAnimale.getAnimali());
        return "animali";
    }

    // @GetMapping("/animali/{id}")
    // public String dettagliAnimale(@PathVariable("id") int id, Model m) {
    //     m.addAttribute("animale", srvAnimale.getAnimaleByIdAnimale(id));
    //     return "DettagliAnimali";
    // }
    

    @GetMapping("/animali/{id}")
    public String dettaglioAnimale(@PathVariable int id, Model model) {
        Animale animale = srvAnimale.getAnimaleByIdAnimale(id); 
        List<Diario> diari = srvDiario.getDiariByAnimaleId(animale.getId_animale()); 
        model.addAttribute("animale", animale);
        model.addAttribute("diari", diari);

        return "dettagliAnimale"; 
    }







    


}


