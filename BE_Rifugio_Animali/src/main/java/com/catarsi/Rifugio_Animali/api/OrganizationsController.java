package com.catarsi.Rifugio_Animali.api;

import com.catarsi.Rifugio_Animali.business.services.OrganizationService;
import com.catarsi.Rifugio_Animali.views.item.OrganizationView;
import com.catarsi.Rifugio_Animali.views.request.OrganizationRequest;
import jakarta.annotation.security.RolesAllowed;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/organizations")
public class OrganizationsController {

    private final OrganizationService organizationService;

    public OrganizationsController(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }

    @RolesAllowed({"USER", "ADMIN"})
    @GetMapping
    public Page<OrganizationView> findAll(Pageable pageable) {
        return organizationService.findAll(pageable);
    }

    @RolesAllowed({"USER", "ADMIN"})
    @GetMapping("/{id}")
    public OrganizationView findById(@PathVariable int id) {
        return organizationService.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Organization not found for id=" + id));
    }

    @RolesAllowed({"ADMIN"})
    @PostMapping
    public int create(@RequestBody OrganizationRequest organizationRequest) {
        return organizationService.create(organizationRequest);
    }

    @RolesAllowed({"ADMIN"})
    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable int id, @RequestBody OrganizationRequest organizationRequest) {
        organizationService.update(organizationRequest, id);
    }

    @RolesAllowed({"ADMIN"})
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        organizationService.delete(id);
    }
}
