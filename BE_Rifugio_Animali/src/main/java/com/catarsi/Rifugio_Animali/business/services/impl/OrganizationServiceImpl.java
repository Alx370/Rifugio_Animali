package com.catarsi.Rifugio_Animali.business.services.impl;

import com.catarsi.Rifugio_Animali.business.model.Organization;
import com.catarsi.Rifugio_Animali.business.repos.OrganizationRepository;
import com.catarsi.Rifugio_Animali.business.services.OrganizationService;
import com.catarsi.Rifugio_Animali.views.item.OrganizationView;
import com.catarsi.Rifugio_Animali.views.request.OrganizationRequest;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrganizationServiceImpl implements OrganizationService {

    private final OrganizationRepository repository;
    private final ModelMapper mapper;

    public OrganizationServiceImpl(OrganizationRepository repository, ModelMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Page<OrganizationView> findAll(Pageable pageable) {
        return repository.findAll(pageable)
                .map(organization -> mapper.map(organization, OrganizationView.class));
    }

    @Override
    public Optional<OrganizationView> findById(int id) {
        return repository.findById(id)
                .map(organization -> mapper.map(organization, OrganizationView.class));
    }

    @Override
    public int create(OrganizationRequest organizationRequest) {
        Organization organization = new Organization();

        organizationRequest.getName().ifPresentOrElse(organization::setName, () -> organization.setName(null));
        organizationRequest.getEmail().ifPresentOrElse(organization::setEmail, () -> organization.setEmail(null));
        organizationRequest.getTelephone().ifPresentOrElse(organization::setTelephone, () -> organization.setTelephone(null));

        Organization saved = repository.save(organization);
        return saved.getId();
    }

    @Override
    public void update(OrganizationRequest organizationRequest, int id) {
        Organization organization = repository.findById(id).orElseThrow(EntityNotFoundException::new);

        organizationRequest.getName().ifPresent(organization::setName);
        organizationRequest.getEmail().ifPresent(organization::setEmail);
        organizationRequest.getTelephone().ifPresent(organization::setTelephone);

        repository.save(organization);
    }

    @Override
    public void delete(int id) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("Organization not found with id: " + id);
        }
        repository.deleteById(id);
    }

    public List<Organization> findAllOrganizations() {
        return repository.findAll();
    }
}
