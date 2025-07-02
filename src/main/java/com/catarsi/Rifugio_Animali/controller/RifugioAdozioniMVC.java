package com.catarsi.Rifugio_Animali.controller;


import com.catarsi.Rifugio_Animali.model.Adozione;
import com.catarsi.Rifugio_Animali.model.Animale;
import com.catarsi.Rifugio_Animali.repos.RifugioRepoAdozione;
import com.catarsi.Rifugio_Animali.services.RifugioServiceAdozione;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

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


    @GetMapping("/backoffice/adozione")
    public String backofficeAdozione(Model m) {
        m.addAttribute("animali", srvAdozione.getAdozioni());
        return "backofficeAdozioni";
    }

        @GetMapping("/backoffice/adozioni/add")
    public String showForm(Model model) {
        model.addAttribute("adozione", new Adozione());
        return "backofficeAdozioni"; 
    }

    @PostMapping("/backoffice/animali/add")
    public String processForm(@ModelAttribute Adozione adozione) {
        srvAdozione.addAdozione(adozione); 
        return "redirect:/backoffice/adozione";
    }

    }
