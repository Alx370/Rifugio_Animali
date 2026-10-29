package com.catarsi.Rifugio_Animali.api;

import com.catarsi.Rifugio_Animali.business.services.AnimalService;
import com.catarsi.Rifugio_Animali.views.item.AnimalView;
import com.catarsi.Rifugio_Animali.views.request.AnimalRequest;
import com.catarsi.Rifugio_Animali.views.request.AnimalSearchRequest;
import jakarta.annotation.security.RolesAllowed;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/animals")
public class AnimalsController {

    private final AnimalService animalService;

    public AnimalsController(AnimalService animalService) {
        this.animalService = animalService;
    }

    @RolesAllowed({"USER", "ADMIN"})
    @GetMapping
    public Page<AnimalView> findAll(@ModelAttribute AnimalSearchRequest request, Pageable pageable) {
        return animalService.search(request, pageable);
    }

    @RolesAllowed({"USER", "ADMIN"})
    @GetMapping("/{id}")
    public AnimalView findById(@PathVariable int id) {
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
}
