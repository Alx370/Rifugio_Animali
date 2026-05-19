package com.catarsi.Rifugio_Animali.business.services.impl;

import com.catarsi.Rifugio_Animali.business.model.Visit;
import com.catarsi.Rifugio_Animali.business.repos.AnimalRepository;
import com.catarsi.Rifugio_Animali.business.repos.VeterinarianRepository;
import com.catarsi.Rifugio_Animali.business.repos.VisitRepository;
import com.catarsi.Rifugio_Animali.business.services.VisitService;
import com.catarsi.Rifugio_Animali.views.item.VisitView;
import com.catarsi.Rifugio_Animali.views.request.VisitRequest;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class VisitServiceImpl implements VisitService {

    private final VisitRepository repository;
    private final AnimalRepository animalRepository;
    private final VeterinarianRepository veterinarianRepository;
    private final ModelMapper mapper;

    public VisitServiceImpl(VisitRepository repository, AnimalRepository animalRepository, VeterinarianRepository veterinarianRepository, ModelMapper mapper) {
        this.repository = repository;
        this.animalRepository = animalRepository;
        this.veterinarianRepository = veterinarianRepository;
        this.mapper = mapper;
    }

    @Override
    public Page<VisitView> findAll(Pageable pageable) {
        return repository.findAll(pageable)
                .map(visit -> mapper.map(visit, VisitView.class));
    }

    @Override
    public Optional<VisitView> findById(int id) {
        return repository.findById(id)
                .map(visit -> mapper.map(visit, VisitView.class));
    }

    @Override
    public int create(VisitRequest visitRequest) {
        Visit visit = new Visit();

        if (visitRequest.getAnimal() != null && visitRequest.getAnimal().isPresent()) {
            Integer animalId = visitRequest.getAnimal().get();
            if (!animalRepository.existsById(animalId)) {
                throw new EntityNotFoundException("Animal not found with id: " + animalId);
            }
            visit.setAnimal(animalRepository.getReferenceById(animalId));
        }

        if (visitRequest.getVeterinarian() != null && visitRequest.getVeterinarian().isPresent()) {
            Integer veterinarianId = visitRequest.getVeterinarian().get();
            if (!veterinarianRepository.existsById(veterinarianId)) {
                throw new EntityNotFoundException("Veterinarian not found with id: " + veterinarianId);
            }
            visit.setVeterinarian(veterinarianRepository.getReferenceById(veterinarianId));
        }

        visitRequest.getVisitDate().ifPresentOrElse(visit::setVisitDate, () -> visit.setVisitDate((LocalDate) null));
        visitRequest.getVisitType().ifPresentOrElse(visit::setVisitType, () -> visit.setVisitType(null));
        visitRequest.getDescription().ifPresentOrElse(visit::setDescription, () -> visit.setDescription(null));
        visitRequest.getCost().ifPresentOrElse(visit::setCost, () -> visit.setCost(null));

        Visit saved = repository.save(visit);
        return saved.getId();
    }

    @Override
    public void update(VisitRequest visitRequest, int id) {
        Visit visit = repository.findById(id).orElseThrow(EntityNotFoundException::new);

        if (visitRequest.getAnimal() != null && visitRequest.getAnimal().isPresent()) {
            Integer animalId = visitRequest.getAnimal().get();
            if (!animalRepository.existsById(animalId)) {
                throw new EntityNotFoundException("Animal not found with id: " + animalId);
            }
            visit.setAnimal(animalRepository.getReferenceById(animalId));
        }

        if (visitRequest.getVeterinarian() != null && visitRequest.getVeterinarian().isPresent()) {
            Integer veterinarianId = visitRequest.getVeterinarian().get();
            if (!veterinarianRepository.existsById(veterinarianId)) {
                throw new EntityNotFoundException("Veterinarian not found with id: " + veterinarianId);
            }
            visit.setVeterinarian(veterinarianRepository.getReferenceById(veterinarianId));
        }

        visitRequest.getVisitDate().ifPresent(visit::setVisitDate);
        visitRequest.getVisitType().ifPresent(visit::setVisitType);
        visitRequest.getDescription().ifPresent(visit::setDescription);
        visitRequest.getCost().ifPresent(visit::setCost);

        repository.save(visit);
    }

    @Override
    public void delete(int id) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("Visit not found with id: " + id);
        }
        repository.deleteById(id);
    }
}
