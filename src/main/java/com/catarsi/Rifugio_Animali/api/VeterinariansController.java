package com.catarsi.Rifugio_Animali.api;

import com.catarsi.Rifugio_Animali.business.services.VeterinarianService;
import com.catarsi.Rifugio_Animali.views.item.VeterinarianView;
import com.catarsi.Rifugio_Animali.views.request.VeterinarianRequest;
import jakarta.annotation.security.RolesAllowed;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/veterinarians")
public class VeterinariansController {

    private final VeterinarianService veterinarianService;

    public VeterinariansController(VeterinarianService veterinarianService) {
        this.veterinarianService = veterinarianService;
    }

    @RolesAllowed({"USER", "ADMIN"})
    @GetMapping
    public Page<VeterinarianView> findAll(Pageable pageable) {
        return veterinarianService.findAll(pageable);
    }

    @RolesAllowed({"USER", "ADMIN"})
    @GetMapping("/{id}")
    public VeterinarianView findById(@PathVariable int id) {
        return veterinarianService.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Veterinarian not found for id=" + id));
    }

    @RolesAllowed({"ADMIN"})
    @PostMapping
    public int create(@RequestBody VeterinarianRequest veterinarianRequest) {
        return veterinarianService.create(veterinarianRequest);
    }

    @RolesAllowed({"ADMIN"})
    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable int id, @RequestBody VeterinarianRequest veterinarianRequest) {
        veterinarianService.update(veterinarianRequest, id);
    }

    @RolesAllowed({"ADMIN"})
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        veterinarianService.delete(id);
    }
}
