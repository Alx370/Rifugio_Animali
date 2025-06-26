package com.catarsi.Rifugio_Animali.controller;

import com.catarsi.Rifugio_Animali.repos.RifugioRepoAnimale;
import com.catarsi.Rifugio_Animali.repos.RifugioRepoDiario;
import com.catarsi.Rifugio_Animali.services.RifugioServiceAnimali;
import com.catarsi.Rifugio_Animali.services.RifugioServiceDiario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class RifugioAnimaliMVC {


    @Autowired
    private final RifugioRepoAnimale repoAnimale;

    @Autowired
    private final RifugioRepoDiario repoDiario;

    @Autowired
    private RifugioServiceAnimali srvAnimale;

    @Autowired
    private RifugioServiceDiario srvDiario;

    public RifugioAnimaliMVC(RifugioRepoAnimale repoAnimale, RifugioRepoDiario repoDiario) {
        this.repoAnimale = repoAnimale;
        this.repoDiario = repoDiario;
    }

    @GetMapping("/animali")
    public String getAnimali(Model m) {
        m.addAttribute("animali", srvAnimale.getAnimali());
        return "animali";
    }

    @GetMapping("/animali/{id}")
    public String dettagliAnimale(@PathVariable("id") int id, Model m) {
        m.addAttribute("animale", srvAnimale.getAnimaleByIdAnimale(id));
        return "DettagliAnimali";
    }

    @GetMapping("/animali/delete/{id}")
    public String deleteAnimale(@PathVariable("id") int id) {
        srvDiario.deleteDiario(id);
        srvAnimale.deleteAnimale(id);
        return "redirect:/animali";
    }


}


