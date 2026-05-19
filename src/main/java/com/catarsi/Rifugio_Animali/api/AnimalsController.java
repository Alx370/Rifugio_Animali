package com.catarsi.Rifugio_Animali.api;

import com.catarsi.Rifugio_Animali.business.services.AnimalService;
import com.catarsi.Rifugio_Animali.views.item.AnimalView;
import com.catarsi.Rifugio_Animali.views.request.AnimalRequest;
import jakarta.annotation.security.RolesAllowed;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/animals")
public class AnimalsController {

    private final AnimalService animalService;

    public AnimalsController(AnimalService animalService) {
        this.animalService = animalService;
    }

    @RolesAllowed({"USER", "ADMIN"})
    @GetMapping
    public Page<AnimalView> findAll(Pageable pageable) {
        return animalService.findAll(pageable);
    }

    @RolesAllowed({"USER", "ADMIN"})
    @GetMapping("/{id}")
    public AnimalView findById(int id) {
        return animalService.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Animal not found for id=" + id));
    }

    @RolesAllowed({"USER", "ADMIN"})
    @PostMapping
    public int create (@RequestBody AnimalRequest animalRequest) {
        return animalService.create(animalRequest);
    }

    @RolesAllowed({"USER", "ADMIN"})
    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable int id, @RequestBody AnimalRequest animalRequest) {
        animalService.update(animalRequest, id);
    }

    @RolesAllowed({"ADMIN"})
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        animalService.delete(id);
    }

 // -----------------------------------------------------------------------------------------------------------
//
//    @RolesAllowed({"USER", "ADMIN"})
//    @GetMapping("/dettaglio/{id}")
//    public String dettaglioAnimale(@PathVariable int id, Model model) {
//        Animal animal = srvAnimale.getAnimaleByIdAnimale(id);
//        List<Diary> diari = srvDiario.getDiariByAnimaleId(animal.getId_animale());
//        model.addAttribute("animale", animal);
//        model.addAttribute("diari", diari);
//        return "dettagliAnimale";
//    }
//
//    @GetMapping("backoffice/animali/dettaglio/{id}")
//    public String BackofficeDettaglioAnimale(@PathVariable int id, Model model) {
//        Animal animal = srvAnimale.getAnimaleByIdAnimale(id);
//        List<Diary> diari = srvDiario.getDiariByAnimaleId(animal.getId_animale());
//        model.addAttribute("animale", animal);
//        model.addAttribute("diari", diari);
//        return "backofficeDettagliAnimali";
//    }
//
//    @GetMapping("/animali/filtra")
//    public String filtraAnimali(
//            @RequestParam(required = false) String nome,
//            @RequestParam(required = false) String sesso,
//            @RequestParam(required = false) String specie,
//            @RequestParam(required = false) String razza,
//            @RequestParam(required = false) Double peso,
//            @RequestParam(required = false) Integer eta,
//            Model model
//    ) {
//        List<Animal> animaliFiltrati = srvAnimale.filtraAnimali(nome, sesso, specie, razza, peso, eta);
//        model.addAttribute("animali", animaliFiltrati);
//        return "Animali"; // la pagina che mostra la lista filtrata
//    }
//
//    @GetMapping("admin/animali/filtra")
//    public String filtraBackofficeAnimali(
//            @RequestParam(required = false) String nome,
//            @RequestParam(required = false) String sesso,
//            @RequestParam(required = false) String specie,
//            @RequestParam(required = false) String razza,
//            @RequestParam(required = false) Double peso,
//            @RequestParam(required = false) Integer eta,
//            Model model
//    ) {
//        List<Animal> animaliFiltrati = srvAnimale.filtraAnimali(nome, sesso, specie, razza, peso, eta);
//        model.addAttribute("animali", animaliFiltrati);
//        return "backofficeVistaAnimali";
//    }
//
//    @GetMapping("/animali/adozioni/filtra")
//    public String filtraAdozioniAnimali(
//            @RequestParam(required = false) String nome,
//            @RequestParam(required = false) String sesso,
//            @RequestParam(required = false) String specie,
//            @RequestParam(required = false) String razza,
//            @RequestParam(required = false) Double peso,
//            @RequestParam(required = false) Integer eta,
//            Model model
//    ) {
//        List<Animal> animaliFiltrati = srvAnimale.filtraAnimali(nome, sesso, specie, razza, peso, eta);
//        model.addAttribute("animali", animaliFiltrati);
//        return "visualizzaAnimaliAdozione";
//    }

}
