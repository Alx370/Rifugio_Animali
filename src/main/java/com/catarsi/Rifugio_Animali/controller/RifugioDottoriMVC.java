package com.catarsi.Rifugio_Animali.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.catarsi.Rifugio_Animali.model.Animale;
import com.catarsi.Rifugio_Animali.model.Dottore;
import com.catarsi.Rifugio_Animali.repos.RifugioRepoDottore;
import com.catarsi.Rifugio_Animali.services.RifugioServiceDottore;



@Controller
public class RifugioDottoriMVC {

    @Autowired
    private RifugioRepoDottore repoDottori;

    @Autowired
    private RifugioServiceDottore srvDottori;

    public RifugioDottoriMVC(RifugioRepoDottore repoDottori, RifugioServiceDottore srvDottori) {
        this.repoDottori = repoDottori;
        this.srvDottori = srvDottori;
    }

    @GetMapping("/backoffice/dottori")
    public String getDottori(Model m) {
        m.addAttribute("dottori", srvDottori.getDottori());
        return "backofficeDottori";
    }

    @GetMapping("/backoffice/dottori/add")
    public String showForm(Model model) {
        model.addAttribute("dottore", new Dottore());
        return "/backofficeAggiungiDottore"; 
    }

    @PostMapping("/backoffice/dottori/add")
    public String processForm(@ModelAttribute Dottore dottore) {
        srvDottori.addDottore(dottore);
        return "redirect:/backoffice/dottori";
    }

    


}


