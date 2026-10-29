package com.catarsi.Rifugio_Animali.business.services.impl;

import java.util.List;
import java.util.Optional;

import com.catarsi.Rifugio_Animali.business.model.Veterinarian;
import com.catarsi.Rifugio_Animali.business.repos.VeterinarianRepository;
import com.catarsi.Rifugio_Animali.business.services.VeterinarianService;
import com.catarsi.Rifugio_Animali.views.item.VeterinarianView;
import com.catarsi.Rifugio_Animali.views.request.VeterinarianRequest;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class VeterinarianServiceImpl implements VeterinarianService {

    private final VeterinarianRepository repository;
    private final ModelMapper mapper;

    public VeterinarianServiceImpl(VeterinarianRepository repository, ModelMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Page<VeterinarianView> findAll(Pageable pageable) {
        return repository.findAll(pageable)
                .map(veterinarian -> mapper.map(veterinarian, VeterinarianView.class));
    }

    @Override
    public Optional<VeterinarianView> findById(int id) {
        return repository.findById(id)
                .map(veterinarian -> mapper.map(veterinarian, VeterinarianView.class));
    }

    @Override
    public int create(VeterinarianRequest veterinarianRequest) {
        Veterinarian veterinarian = new Veterinarian();

        veterinarianRequest.getFirstName().ifPresentOrElse(veterinarian::setFirstName, () -> veterinarian.setFirstName(null));
        veterinarianRequest.getLastName().ifPresentOrElse(veterinarian::setLastName, () -> veterinarian.setLastName(null));
        veterinarianRequest.getEmail().ifPresentOrElse(veterinarian::setEmail, () -> veterinarian.setEmail(null));
        veterinarianRequest.getPhone().ifPresentOrElse(veterinarian::setPhone, () -> veterinarian.setPhone(null));
        veterinarianRequest.getGender().ifPresentOrElse(veterinarian::setGender, () -> veterinarian.setGender(null));

        Veterinarian saved = repository.save(veterinarian);
        return saved.getId();
    }

    @Override
    public void update(VeterinarianRequest veterinarianRequest, int id) {
        Veterinarian veterinarian = repository.findById(id).orElseThrow(EntityNotFoundException::new);

        veterinarianRequest.getFirstName().ifPresent(veterinarian::setFirstName);
        veterinarianRequest.getLastName().ifPresent(veterinarian::setLastName);
        veterinarianRequest.getEmail().ifPresent(veterinarian::setEmail);
        veterinarianRequest.getPhone().ifPresent(veterinarian::setPhone);
        veterinarianRequest.getGender().ifPresent(veterinarian::setGender);

        repository.save(veterinarian);
    }

    @Override
    public void delete(int id) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("Veterinarian not found with id: " + id);
        }
        repository.deleteById(id);
    }

    public List<Veterinarian> findAllVeterinarians() {
        return repository.findAll();
    }
}
