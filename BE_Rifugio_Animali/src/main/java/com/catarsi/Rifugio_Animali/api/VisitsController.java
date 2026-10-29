package com.catarsi.Rifugio_Animali.api;

import com.catarsi.Rifugio_Animali.business.services.VisitService;
import com.catarsi.Rifugio_Animali.views.item.VisitView;
import com.catarsi.Rifugio_Animali.views.request.VisitRequest;
import jakarta.annotation.security.RolesAllowed;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/visits")
public class VisitsController {

    private final VisitService visitService;

    public VisitsController(VisitService visitService) {
        this.visitService = visitService;
    }

    @RolesAllowed({"USER", "ADMIN"})
    @GetMapping
    public Page<VisitView> findAll(Pageable pageable) {
        return visitService.findAll(pageable);
    }

    @RolesAllowed({"USER", "ADMIN"})
    @GetMapping("/{id}")
    public VisitView findById(@PathVariable int id) {
        return visitService.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Visit not found for id=" + id));
    }

    @RolesAllowed({"ADMIN"})
    @PostMapping
    public int create(@Valid @RequestBody VisitRequest visitRequest) {
        return visitService.create(visitRequest);
    }

    @RolesAllowed({"ADMIN"})
    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable int id, @Valid @RequestBody VisitRequest visitRequest) {
        visitService.update(visitRequest, id);
    }

    @RolesAllowed({"ADMIN"})
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        visitService.delete(id);
    }
}
