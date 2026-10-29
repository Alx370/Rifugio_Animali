package com.catarsi.Rifugio_Animali.api;

import com.catarsi.Rifugio_Animali.business.services.DonationService;
import com.catarsi.Rifugio_Animali.views.item.DonationView;
import com.catarsi.Rifugio_Animali.views.request.DonationRequest;
import jakarta.annotation.security.RolesAllowed;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/donations")
public class DonationsController {

    private final DonationService donationService;

    public DonationsController(DonationService donationService) {
        this.donationService = donationService;
    }

    @RolesAllowed({"USER", "ADMIN"})
    @GetMapping
    public Page<DonationView> findAll(Pageable pageable, Authentication authentication) {
        return donationService.findAll(pageable, authentication.getName(), isAdmin(authentication));
    }

    @RolesAllowed({"USER", "ADMIN"})
    @GetMapping("/{id}")
    public DonationView findById(@PathVariable int id, Authentication authentication) {
        return donationService.findById(id, authentication.getName(), isAdmin(authentication))
                .orElseThrow(() -> new EntityNotFoundException("Donation not found for id=" + id));
    }

    @RolesAllowed({"USER", "ADMIN"})
    @PostMapping
    public int create(@Valid @RequestBody DonationRequest donationRequest, Principal principal) {
        return donationService.create(donationRequest, principal.getName());
    }

    @RolesAllowed({"ADMIN"})
    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable int id, @Valid @RequestBody DonationRequest donationRequest) {
        donationService.update(donationRequest, id);
    }

    @RolesAllowed({"ADMIN"})
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        donationService.delete(id);
    }

    private boolean isAdmin(Authentication authentication) {
        return authentication.getAuthorities().stream()
                .anyMatch(authority -> authority.getAuthority().equals("ROLE_ADMIN"));
    }
}
