package com.catarsi.Rifugio_Animali.business.services.impl;

import com.catarsi.Rifugio_Animali.business.model.Adoption;
import com.catarsi.Rifugio_Animali.business.model.enums.RequestStatus;
import com.catarsi.Rifugio_Animali.business.repos.UserRepository;
import com.catarsi.Rifugio_Animali.business.services.AdoptionService;
import com.catarsi.Rifugio_Animali.views.item.AdoptionView;
import com.catarsi.Rifugio_Animali.views.request.AdoptionRequest;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.catarsi.Rifugio_Animali.business.repos.AdoptionRepository;
import com.catarsi.Rifugio_Animali.business.repos.AnimalRepository;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

@Service
public class AdoptionServiceImpl implements AdoptionService {

    private final AdoptionRepository repository;
    private final AnimalRepository animalRepository;
    private final UserRepository userRepository;
    private final ModelMapper mapper;

    public AdoptionServiceImpl(AdoptionRepository repository, AnimalRepository animalRepository, UserRepository userRepository, ModelMapper mapper) {
        this.repository = repository;
        this.animalRepository = animalRepository;
        this.userRepository = userRepository;
        this.mapper = mapper;
    }

    @Override
    public Page<AdoptionView> findAll(Pageable peagable) {
        return repository.findAll(peagable) .map(as -> mapper.map(as, AdoptionView.class));
    }

    @Override
    public Page<AdoptionView> findAll(Pageable pageable, String userEmail, boolean admin) {
        return (admin ? repository.findAll(pageable) : repository.findByUserEmail(userEmail, pageable))
                .map(adoption -> mapper.map(adoption, AdoptionView.class));
    }

    @Override
    public Optional<AdoptionView> findById(int id) {
        return repository.findById(id) .map(as -> mapper.map(as, AdoptionView.class));
    }

    @Override
    public Optional<AdoptionView> findById(int id, String userEmail, boolean admin) {
        return (admin ? repository.findById(id) : repository.findByIdAndUserEmail(id, userEmail))
                .map(adoption -> mapper.map(adoption, AdoptionView.class));
    }

    @Override
    public int create(AdoptionRequest a, String userEmail) {
        Adoption adoption = new Adoption();

        adoption.setUser(userRepository.findByEmail(userEmail)
                .orElseThrow(() -> new EntityNotFoundException("User not found with email: " + userEmail)));

        if (a.getAnimal() != null && a.getAnimal().isPresent()) {
            Integer AnimalCode = a.getAnimal().get();
            if (!animalRepository.existsById(AnimalCode)) {
                throw new EntityNotFoundException("Animal not found with id: " + AnimalCode);
            }
            adoption.setAnimal(animalRepository.getReferenceById(AnimalCode));
        }

        a.getAdoptionDate().ifPresentOrElse(adoption::setAdoptionDate, () -> adoption.setAdoptionDate(null));
        a.getNote().ifPresentOrElse(adoption::setNote, () -> adoption.setNote(null));
        a.getStatus().ifPresentOrElse(adoption::setStatus, () -> adoption.setStatus(RequestStatus.RICHIESTA));

        Adoption saved = repository.save(adoption);
        return saved.getId();
    }

    @Override
    public void update(AdoptionRequest a, int id) {
        Adoption adoption = repository.findById(id).orElseThrow(EntityNotFoundException::new);

        if (a.getAnimal() != null && a.getAnimal().isPresent()) {
            Integer AnimalCode = a.getAnimal().get();
            if (!animalRepository.existsById(AnimalCode)) {
                throw new EntityNotFoundException("Animal not found with id: " + AnimalCode);
            }
            adoption.setAnimal(animalRepository.getReferenceById(AnimalCode));
        }

        a.getAdoptionDate().ifPresentOrElse(adoption::setAdoptionDate, () -> adoption.setAdoptionDate(null));
        a.getNote().ifPresentOrElse(adoption::setNote, () -> adoption.setNote(null));
        a.getStatus().ifPresent(adoption::setStatus);
        repository.save(adoption);
    }

    @Override
    public void delete(int id) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("Adoption not found with id: " + id);
        }
        repository.deleteById(id);
    }

    public List<Adoption> getAdozioni() {
        return repository.findAll();
    }
}
