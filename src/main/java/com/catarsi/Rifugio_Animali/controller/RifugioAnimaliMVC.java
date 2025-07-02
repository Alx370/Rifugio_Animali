package com.catarsi.Rifugio_Animali.controller;

import com.catarsi.Rifugio_Animali.model.Animale;
import com.catarsi.Rifugio_Animali.model.Diario;
import com.catarsi.Rifugio_Animali.repos.RifugioRepoAnimale;
import com.catarsi.Rifugio_Animali.repos.RifugioRepoDiario;
import com.catarsi.Rifugio_Animali.services.RifugioServiceAnimali;
import com.catarsi.Rifugio_Animali.services.RifugioServiceDiario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

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
    public String dettaglioAnimale(@PathVariable int id, Model model) {
        Animale animale = srvAnimale.getAnimaleByIdAnimale(id); 
        List<Diario> diari = srvDiario.getDiariByAnimaleId(animale.getId_animale());
        model.addAttribute("animale", animale);
        model.addAttribute("diari", diari);

        return "dettagliAnimale"; 
    }

    @GetMapping("/animali/delete/{id}")
    public String deleteAnimale(@PathVariable("id") int id) {
        srvDiario.deleteDiario(id);
        srvAnimale.deleteAnimale(id);
        return "redirect:/backofficeAnimali";
    }

    @GetMapping("/backoffice/animali")
    public String backofficeAnimali(Model m) {
        m.addAttribute("animali", srvAnimale.getAnimali());
        return "backofficeAnimali";
    }

    @GetMapping("/backoffice/animali/add")
public String showForm(Model model) {
    model.addAttribute("animale", new Animale());
    return "backofficeAggiungi"; // Nome del template HTML per il form di aggiunta
}

@PostMapping("/backoffice/animali/add")
public String processForm(@ModelAttribute Animale animale) {
    srvAnimale.addAnimale(animale); 
    return "redirect:/backoffice/animali";
}








    


}


