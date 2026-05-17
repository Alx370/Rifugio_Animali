package com.catarsi.Rifugio_Animali.controller;

import com.catarsi.Rifugio_Animali.model.Diary;
import com.catarsi.Rifugio_Animali.services.RifugioServiceAnimaliImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.catarsi.Rifugio_Animali.repos.RifugioRepoDiario;
import com.catarsi.Rifugio_Animali.services.RifugioServiceDiarioImpl;
import org.springframework.web.bind.annotation.*;


@Controller
public class RifugioDiarioMVC {

    private final RifugioRepoDiario repoDiario;

    @Autowired
    private RifugioServiceAnimaliImpl srvAnimali;

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
        model.addAttribute("diario", new Diary());
        model.addAttribute("animali", srvAnimali.getAnimali());
        return "backofficeAggiungiDiario";
    }

    @PostMapping("/backoffice/diario/add")
    public String processForm(@ModelAttribute Diary diary) {
        srvDiario.addDiario(diary);
        return "redirect:/backoffice/animali";
    }

    @GetMapping("/diario/update/{id}")
    public String mostraFormUpdateDaAnimale(@PathVariable("id") int idAnimale, Model model) {
        Diary diary = srvDiario.getDiarioByAnimaleId(idAnimale);
        model.addAttribute("diario", diary);
        model.addAttribute("animali", srvAnimali.getAnimali());
        return "backofficeUpdateDiario";
    }

    @PostMapping("/diario/update")
    public String updateDiario(@RequestParam("id") int id, @ModelAttribute("diario") Diary aggiornato) {
        Diary esistente = srvDiario.getDiarioById(id);
        esistente.setStoria_animale(aggiornato.getStoria_animale());
        esistente.setStato_salute(aggiornato.getStato_salute());
        esistente.setStato_comportamentale(aggiornato.getStato_comportamentale());
        esistente.setVaccinazioni(aggiornato.getVaccinazioni());
        esistente.setOperazioni_effettuate(aggiornato.getOperazioni_effettuate());
        srvDiario.addDiario(esistente);
        return "redirect:/backoffice/diari";
    }


}















