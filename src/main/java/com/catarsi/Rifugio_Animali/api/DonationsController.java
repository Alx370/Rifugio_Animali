package com.catarsi.Rifugio_Animali.api;

import com.catarsi.Rifugio_Animali.business.services.DonationService;
import com.catarsi.Rifugio_Animali.views.item.DonationView;
import com.catarsi.Rifugio_Animali.views.request.DonationRequest;
import jakarta.annotation.security.RolesAllowed;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/donations")
public class DonationsController {

    private final DonationService donationService;

    public DonationsController(DonationService donationService) {
        this.donationService = donationService;
    }

    @RolesAllowed({"USER", "ADMIN"})
    @GetMapping
    public Page<DonationView> findAll(Pageable pageable) {
        return donationService.findAll(pageable);
    }

    @RolesAllowed({"USER", "ADMIN"})
    @GetMapping("/{id}")
    public DonationView findById(@PathVariable int id) {
        return donationService.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Donation not found for id=" + id));
    }

    @RolesAllowed({"USER", "ADMIN"})
    @PostMapping
    public int create(@RequestBody DonationRequest donationRequest) {
        return donationService.create(donationRequest);
    }

    @RolesAllowed({"USER", "ADMIN"})
    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable int id, @RequestBody DonationRequest donationRequest) {
        donationService.update(donationRequest, id);
    }

    @RolesAllowed({"ADMIN"})
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        donationService.delete(id);
    }
}
