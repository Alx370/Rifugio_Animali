package com.catarsi.Rifugio_Animali.controller;

import com.catarsi.Rifugio_Animali.model.Animal;
import com.catarsi.Rifugio_Animali.model.Diary;
import com.catarsi.Rifugio_Animali.repos.RifugioRepoAnimale;
import com.catarsi.Rifugio_Animali.repos.RifugioRepoDiario;
import com.catarsi.Rifugio_Animali.services.RifugioServiceAnimali;
import com.catarsi.Rifugio_Animali.services.RifugioServiceDiario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


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
        return "Animali";
    }

    @GetMapping("/animali/dettaglio/{id}")
    public String dettaglioAnimale(@PathVariable int id, Model model) {
        Animal animal = srvAnimale.getAnimaleByIdAnimale(id);
        List<Diary> diari = srvDiario.getDiariByAnimaleId(animal.getId_animale());
        model.addAttribute("animale", animal);
        model.addAttribute("diari", diari);
        return "dettagliAnimale";
    }

    @GetMapping("/animali/delete/{id}")
    public String deleteAnimale(@PathVariable("id") int id) {
        srvDiario.deleteDiario(id);
        srvAnimale.deleteAnimale(id);
        return "redirect:/backoffice/animali";
    }

    @GetMapping("/backoffice/animali")
    public String backofficeAnimali(Model m) {
        m.addAttribute("animali", srvAnimale.getAnimali());
        return "backofficeVistaAnimali";
    }

    @GetMapping("/backoffice/animali/add")
    public String showForm(Model model) {
        model.addAttribute("animale", new Animal());
        return "backofficeAddAnimali";
    }

    @PostMapping("/backoffice/animali/add")
    public String processForm(@ModelAttribute Animal animal) {
        srvAnimale.addAnimale(animal);
        return "redirect:/backoffice/animali";
    }

    @GetMapping("backoffice/animali/dettaglio/{id}")
    public String BackofficeDettaglioAnimale(@PathVariable int id, Model model) {
        Animal animal = srvAnimale.getAnimaleByIdAnimale(id);
        List<Diary> diari = srvDiario.getDiariByAnimaleId(animal.getId_animale());
        model.addAttribute("animale", animal);
        model.addAttribute("diari", diari);
        return "backofficeDettagliAnimali";
    }

    @GetMapping("/animali/edit/{id}")
    public String showUpdateForm(@PathVariable("id") int id, Model model) {
        Animal animal = srvAnimale.getAnimaleByIdAnimale(id);
        model.addAttribute("animale", animal);
        return "AnimaliEdit";
    }

    @PostMapping("/animali/update/{id}")
    public String updateAnimale(@PathVariable("id") int id, @ModelAttribute("animale") Animal aggiornato) {
        Animal esistente = srvAnimale.getAnimaleByIdAnimale(id);
        esistente.setNome(aggiornato.getNome());
        esistente.setSpecie(aggiornato.getSpecie());
        esistente.setRazza(aggiornato.getRazza());
        esistente.setPeso(aggiornato.getPeso());
        esistente.setEta(aggiornato.getEta());
        esistente.setSesso(aggiornato.getSesso());
        esistente.setColore(aggiornato.getColore());
        esistente.setData_arrivo(aggiornato.getData_arrivo());
        srvAnimale.addAnimale(esistente);
        return "redirect:/backoffice/animali";
    }

    @GetMapping("/animali/filtra")
    public String filtraAnimali(
            @RequestParam(required = false) String nome,
            @RequestParam(required = false) String sesso,
            @RequestParam(required = false) String specie,
            @RequestParam(required = false) String razza,
            @RequestParam(required = false) Double peso,
            @RequestParam(required = false) Integer eta,
            Model model
    ) {
        List<Animal> animaliFiltrati = srvAnimale.filtraAnimali(nome, sesso, specie, razza, peso, eta);
        model.addAttribute("animali", animaliFiltrati);
        return "Animali"; // la pagina che mostra la lista filtrata
    }

    @GetMapping("admin/animali/filtra")
    public String filtraBackofficeAnimali(
            @RequestParam(required = false) String nome,
            @RequestParam(required = false) String sesso,
            @RequestParam(required = false) String specie,
            @RequestParam(required = false) String razza,
            @RequestParam(required = false) Double peso,
            @RequestParam(required = false) Integer eta,
            Model model
    ) {
        List<Animal> animaliFiltrati = srvAnimale.filtraAnimali(nome, sesso, specie, razza, peso, eta);
        model.addAttribute("animali", animaliFiltrati);
        return "backofficeVistaAnimali";
    }

    @GetMapping("/animali/adozioni/filtra")
    public String filtraAdozioniAnimali(
            @RequestParam(required = false) String nome,
            @RequestParam(required = false) String sesso,
            @RequestParam(required = false) String specie,
            @RequestParam(required = false) String razza,
            @RequestParam(required = false) Double peso,
            @RequestParam(required = false) Integer eta,
            Model model
    ) {
        List<Animal> animaliFiltrati = srvAnimale.filtraAnimali(nome, sesso, specie, razza, peso, eta);
        model.addAttribute("animali", animaliFiltrati);
        return "visualizzaAnimaliAdozione";
    }


}
