package com.catarsi.Rifugio_Animali.controller;


import com.catarsi.Rifugio_Animali.repos.RifugioRepoAdozione;
import com.catarsi.Rifugio_Animali.services.RifugioServiceAdozione;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RifugioAdozioniMVC {

    @Autowired
    private RifugioRepoAdozione repoAdozione;

    @Autowired
    private RifugioServiceAdozione srvAdozione;

    public RifugioAdozioniMVC(RifugioRepoAdozione repoAdozione) {
        this.repoAdozione = repoAdozione;
    }

    @GetMapping("/adozione")
    public String addAdozione(Model m) {
        m.addAttribute("adozioni", srvAdozione.getAdozioni());
        return "adozioni";
    }
}
