package com.catarsi.Rifugio_Animali.business.services.impl;

import java.math.BigDecimal;
import java.util.Optional;

import com.catarsi.Rifugio_Animali.business.model.Donation;
import com.catarsi.Rifugio_Animali.business.repos.DonationRepository;
import com.catarsi.Rifugio_Animali.business.repos.OrganizationRepository;
import com.catarsi.Rifugio_Animali.business.repos.UserRepository;
import com.catarsi.Rifugio_Animali.business.services.DonationService;
import com.catarsi.Rifugio_Animali.views.item.DonationView;
import com.catarsi.Rifugio_Animali.views.request.DonationRequest;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class DonationServiceImpl implements DonationService {

    private final DonationRepository repository;
    private final UserRepository userRepository;
    private final OrganizationRepository organizationRepository;
    private final ModelMapper mapper;

    public DonationServiceImpl(DonationRepository repository, UserRepository userRepository, OrganizationRepository organizationRepository, ModelMapper mapper) {
        this.repository = repository;
        this.userRepository = userRepository;
        this.organizationRepository = organizationRepository;
        this.mapper = mapper;
    }

    @Override
    public Page<DonationView> findAll(Pageable pageable) {
        return repository.findAll(pageable)
                .map(donation -> mapper.map(donation, DonationView.class));
    }

    @Override
    public Page<DonationView> findAll(Pageable pageable, String userEmail, boolean admin) {
        return (admin ? repository.findAll(pageable) : repository.findByUserEmail(userEmail, pageable))
                .map(donation -> mapper.map(donation, DonationView.class));
    }

    @Override
    public Optional<DonationView> findById(int id) {
        return repository.findById(id)
                .map(donation -> mapper.map(donation, DonationView.class));
    }

    @Override
    public Optional<DonationView> findById(int id, String userEmail, boolean admin) {
        return (admin ? repository.findById(id) : repository.findByIdAndUserEmail(id, userEmail))
                .map(donation -> mapper.map(donation, DonationView.class));
    }

    @Override
    public int create(DonationRequest donationRequest, String userEmail) {
        Donation donation = new Donation();

        donation.setUser(userRepository.findByEmail(userEmail)
                .orElseThrow(() -> new EntityNotFoundException("User not found with email: " + userEmail)));

        if (donationRequest.getOrganization() != null && donationRequest.getOrganization().isPresent()) {
            Integer organizationId = donationRequest.getOrganization().get();
            if (!organizationRepository.existsById(organizationId)) {
                throw new EntityNotFoundException("Organization not found with id: " + organizationId);
            }
            donation.setOrganization(organizationRepository.getReferenceById(organizationId));
        }

        donationRequest.getDate().ifPresentOrElse(donation::setDate, () -> donation.setDate(null));
        donationRequest.getSum().ifPresentOrElse(donation::setSum, () -> donation.setSum(null));

        Donation saved = repository.save(donation);
        return saved.getId();
    }

    @Override
    public void update(DonationRequest donationRequest, int id) {
        Donation donation = repository.findById(id).orElseThrow(EntityNotFoundException::new);

        if (donationRequest.getOrganization() != null && donationRequest.getOrganization().isPresent()) {
            Integer organizationId = donationRequest.getOrganization().get();
            if (!organizationRepository.existsById(organizationId)) {
                throw new EntityNotFoundException("Organization not found with id: " + organizationId);
            }
            donation.setOrganization(organizationRepository.getReferenceById(organizationId));
        }

        donationRequest.getDate().ifPresent(donation::setDate);
        donationRequest.getSum().ifPresent(donation::setSum);

        repository.save(donation);
    }

    @Override
    public void delete(int id) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("Donation not found with id: " + id);
        }
        repository.deleteById(id);
    }

    public BigDecimal totalDonations() {
        return repository.sumDonations();
    }
}
