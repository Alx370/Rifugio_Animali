package com.catarsi.Rifugio_Animali.api;

import com.catarsi.Rifugio_Animali.business.services.AdoptionService;
import com.catarsi.Rifugio_Animali.views.item.AdoptionView;
import com.catarsi.Rifugio_Animali.views.request.AdoptionRequest;
import jakarta.annotation.security.RolesAllowed;
import jakarta.validation.Valid;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/adoptions")
public class AdoptionsController {

    private final AdoptionService adoptionService;

    public AdoptionsController(AdoptionService adoptionService) {
        this.adoptionService = adoptionService;
    }

    @RolesAllowed( {"USER", "ADMIN"})
    @GetMapping()
    public Page<AdoptionView> findAll(Pageable pageable, Authentication authentication) {
        return adoptionService.findAll(pageable, authentication.getName(), isAdmin(authentication));
    }

    @RolesAllowed({"USER", "ADMIN"})
    @GetMapping("/{id}")
    public AdoptionView findById(@PathVariable int id, Authentication authentication) {
        return adoptionService.findById(id, authentication.getName(), isAdmin(authentication))
                .orElseThrow(() -> new EntityNotFoundException("Adoption not found for id=" + id));
    }

    @RolesAllowed({"USER", "ADMIN"})
    @PostMapping
    public int create(@Valid @RequestBody AdoptionRequest adoptionRequest, Principal principal) {
        return adoptionService.create(adoptionRequest, principal.getName());
    }

    @RolesAllowed({"ADMIN"})
    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable int id, @Valid @RequestBody AdoptionRequest adoptionRequest) {
        adoptionService.update(adoptionRequest, id);
    }

    @RolesAllowed({"ADMIN"})
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        adoptionService.delete(id);
    }

    private boolean isAdmin(Authentication authentication) {
        return authentication.getAuthorities().stream()
                .anyMatch(authority -> authority.getAuthority().equals("ROLE_ADMIN"));
    }
}
