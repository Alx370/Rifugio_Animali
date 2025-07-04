package com.catarsi.Rifugio_Animali.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.catarsi.Rifugio_Animali.model.Animale;
import com.catarsi.Rifugio_Animali.model.Diario;
import com.catarsi.Rifugio_Animali.repos.RifugioRepoDiario;
import com.catarsi.Rifugio_Animali.services.RifugioServiceDiarioImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class RifugioDiarioMVC {

    private final RifugioRepoDiario repoDiario;

    @Autowired
    private RifugioServiceDiarioImpl srvDiario; 

    public RifugioDiarioMVC(RifugioRepoDiario repoDiario){
        this.repoDiario = repoDiario;
    }

    @GetMapping("/diari")
    public String getMethodName(Model m) {
        m.addAttribute("diari", srvDiario.getDiari());
        return "diari";
    }
    

    
    @GetMapping("/backoffice/diari")
    public String backofficeAnimali(Model m) {
        m.addAttribute("diari", srvDiario.getDiari());
        return "backofficeAnimali";
    }

    @GetMapping("/backoffice/diario/add")
    public String showForm(Model model) {
        model.addAttribute("diari", new Diario());
        return "backofficeAggiungiDiario"; 
    }

    @PostMapping("/backoffice/diario/add")
    public String processForm(@ModelAttribute Diario diario) {
        srvDiario.addDiario(diario); 
        return "redirect:/backoffice/animali";
    }
        
    
}















