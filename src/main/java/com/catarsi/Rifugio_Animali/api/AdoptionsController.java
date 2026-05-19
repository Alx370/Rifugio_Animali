package com.catarsi.Rifugio_Animali.api;

import com.catarsi.Rifugio_Animali.business.services.AdoptionService;
import com.catarsi.Rifugio_Animali.views.item.AdoptionView;
import com.catarsi.Rifugio_Animali.views.request.AdoptionRequest;
import jakarta.annotation.security.RolesAllowed;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/adoptions")
public class AdoptionsController {

    private final AdoptionService adoptionService;

    public AdoptionsController(AdoptionService adoptionService) {
        this.adoptionService = adoptionService;
    }

    @RolesAllowed( {"USER", "ADMIN"})
    @GetMapping()
    public Page<AdoptionView> findAll(Pageable pageable) {
        return adoptionService.findAll(pageable);
    }

    @GetMapping("/{id}")
    public AdoptionView findById(@PathVariable int id) {
        return adoptionService.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Adoption not found for id=" + id));
    }

    @RolesAllowed({"USER", "ADMIN"})
    @PostMapping
    public int create (@RequestBody AdoptionRequest adoptionRequest) {
        return adoptionService.create(adoptionRequest);
    }

    @RolesAllowed({"USER", "ADMIN"})
    @PatchMapping("/{id}")
    public void update(int id, @RequestBody AdoptionRequest adoptionRequest) {
        adoptionService.update(adoptionRequest, id);
    }

    @RolesAllowed({"ADMIN"})
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        adoptionService.delete(id);
    }

//        @GetMapping("/adozioni/form")
//    public String mostraFormAdozione(Model model, Principal principal, @RequestParam Integer idAnimale) {
//        if (principal == null) {
//            return "errore_richiesta_login"; // utente non loggato
//        }
}
