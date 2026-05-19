package com.catarsi.Rifugio_Animali.business.services.impl;

import com.catarsi.Rifugio_Animali.business.model.Animal;
import com.catarsi.Rifugio_Animali.business.repos.AnimalRepository;
import com.catarsi.Rifugio_Animali.business.repos.DiaryRepository;
import com.catarsi.Rifugio_Animali.business.repos.VisitRepository;
import com.catarsi.Rifugio_Animali.business.services.AnimalService;
import com.catarsi.Rifugio_Animali.views.item.AnimalView;
import com.catarsi.Rifugio_Animali.views.request.AnimalRequest;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

import org.springframework.data.jpa.domain.Specification;

import java.util.List;
import java.util.Optional;

@Service
public class AnimalServiceImpl implements AnimalService {

    private final AnimalRepository repository;
    private final DiaryRepository repositoryDiary;
    private final VisitRepository repositoryVisit;
    private final ModelMapper mapper;

    public AnimalServiceImpl(AnimalRepository repository, DiaryRepository repositoryDiary, VisitRepository repositoryVisit, ModelMapper mapper) {
        this.repository = repository;
        this.repositoryDiary = repositoryDiary;
        this.repositoryVisit = repositoryVisit;
        this.mapper = mapper;
    }

    @Override
    public Page<AnimalView> findAll (Pageable pageable) {
        return repository.findAll(pageable)
                .map(a -> mapper.map(a, AnimalView.class));
    }

    @Override
    public Optional<AnimalView> findById (int id) {
        return repository.findById(id)
                .map(ass -> mapper.map(ass, AnimalView.class));
    }

    @Override
    public int create(AnimalRequest ar) {
        Animal a = new Animal();
        ar.getSpecies().ifPresentOrElse(a::setSpecies, () -> a.setSpecies(null));
        ar.getName().ifPresentOrElse(a::setName, () -> a.setName(null));
        ar.getMicrochip().ifPresentOrElse(a::setMicrochip, () -> a.setMicrochip(false));
        ar.getArrivalDate().ifPresentOrElse(a::setArrivalDate, () -> a.setArrivalDate(null));
        ar.getBirthDate().ifPresentOrElse(a::setBirthDate, () -> a.setBirthDate(null));
        ar.getAdoptionDate().ifPresentOrElse(a::setAdoptionDate, () -> a.setAdoptionDate(null));
        ar.getBreed().ifPresentOrElse(a::setBreed, () -> a.setBreed(null));
        ar.getGender().ifPresentOrElse(a::setGender, () -> a.setGender(null));
        ar.getWeight().ifPresentOrElse(a::setWeight, () -> a.setWeight(null));
        ar.getSize().ifPresentOrElse(a::setSize, () -> a.setSize(null));
        ar.getColor().ifPresentOrElse(a::setColor, () -> a.setColor(null));
        ar.getDistinctiveMarks().ifPresentOrElse(a::setDistinctiveMarks, () -> a.setDistinctiveMarks(null));
        ar.getSpayedNeutered().ifPresentOrElse(a::setSpayedNeutered, () -> a.setSpayedNeutered(false));
        ar.getAvailableForAdoption().ifPresentOrElse(a::setAvailableForAdoption, () -> a.setAvailableForAdoption(false));
        Animal saved = repository.save(a);
        return saved.getId();
    }

    @Override
    @Transactional
    public void update(AnimalRequest ar, int id) {
        Animal animal = repository.findById(id).orElseThrow(EntityNotFoundException::new);

        ar.getSpecies().ifPresent(animal::setSpecies);
        ar.getName().ifPresent(animal::setName);
        ar.getMicrochip().ifPresent(animal::setMicrochip);
        ar.getArrivalDate().ifPresent(animal::setArrivalDate);
        ar.getBirthDate().ifPresent(animal::setBirthDate);
        ar.getAdoptionDate().ifPresent(animal::setAdoptionDate);
        ar.getBreed().ifPresent(animal::setBreed);
        ar.getGender().ifPresent(animal::setGender);
        ar.getWeight().ifPresent(animal::setWeight);
        ar.getSize().ifPresent(animal::setSize);
        ar.getColor().ifPresent(animal::setColor);
        ar.getDistinctiveMarks().ifPresent(animal::setDistinctiveMarks);
        ar.getSpayedNeutered().ifPresent(animal::setSpayedNeutered);
        ar.getAvailableForAdoption().ifPresent(animal::setAvailableForAdoption);

        repository.save(animal);
    }

    @Override
    public void delete(int id) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("Animal not found with id: " + id);
        }
        repository.deleteById(id);
    }

    @Override
    public Specification<Animal> nomeContains(String nome) {
        return (root, query, cb) ->
                nome == null || nome.isEmpty() ? null : cb.like(cb.lower(root.get("nome")), "%" + nome.toLowerCase() + "%");
    }

    @Override
    public Specification<Animal> sessoEquals(String sesso) {
        return (root, query, cb) ->
                sesso == null || sesso.isEmpty() ? null : cb.equal(root.get("sesso"), sesso);
    }

    @Override
    public Specification<Animal> specieEquals(String specie) {
        return (root, query, cb) ->
                specie == null || specie.isEmpty() ? null : cb.equal(root.get("specie"), specie);
    }

    @Override
    public Specification<Animal> razzaContains(String razza) {
        return (root, query, cb) ->
                razza == null || razza.isEmpty() ? null : cb.like(cb.lower(root.get("razza")), "%" + razza.toLowerCase() + "%");
    }

    @Override
    public Specification<Animal> pesoLessOrEqual(Double peso) {
        return (root, query, cb) ->
                peso == null ? null : cb.lessThanOrEqualTo(root.get("peso"), peso);
    }

    @Override
    public Specification<Animal> etaLessOrEqual(Integer eta) {
        return (root, query, cb) ->
                eta == null ? null : cb.lessThanOrEqualTo(root.get("eta"), eta);
    }

    public List<Animal> filtraAnimali(String nome, String sesso, String specie, String razza, Double peso, Integer eta) {
        return repository.findAll(
                Specification.allOf(
                        nomeContains(nome),
                        sessoEquals(sesso),
                        specieEquals(specie),
                        razzaContains(razza),
                        pesoLessOrEqual(peso),
                        etaLessOrEqual(eta)
                )
        );
    }
}






