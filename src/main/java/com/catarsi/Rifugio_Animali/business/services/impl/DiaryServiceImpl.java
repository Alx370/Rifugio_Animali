package com.catarsi.Rifugio_Animali.business.services.impl;

import java.util.Optional;

import com.catarsi.Rifugio_Animali.business.model.Diary;
import com.catarsi.Rifugio_Animali.business.repos.AnimalRepository;
import com.catarsi.Rifugio_Animali.business.repos.DiaryRepository;
import com.catarsi.Rifugio_Animali.business.services.DiaryService;
import com.catarsi.Rifugio_Animali.views.item.DiaryView;
import com.catarsi.Rifugio_Animali.views.request.DiaryRequest;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class DiaryServiceImpl implements DiaryService {

    private final DiaryRepository repository;
    private final AnimalRepository animalRepository;
    private final ModelMapper mapper;

    public DiaryServiceImpl(DiaryRepository repository, ModelMapper mapper, AnimalRepository animalRepository) {
        this.repository = repository;
        this.animalRepository = animalRepository;
        this.mapper = mapper;
    }

    @Override
    public Page<DiaryView>findAll(Pageable pageable) {
        return repository.findAll(pageable)
                .map(a -> mapper.map(a, DiaryView.class));
    }

    @Override
    public Optional<DiaryView> findById (int id) {
        return repository.findById(id)
                .map(a -> mapper.map(a, DiaryView.class));
    }

    @Override
    public int create (DiaryRequest dr) {
        Diary diary = new Diary();

        if (dr.getAnimal() != null && dr.getAnimal().isPresent()) {
            Integer AnimalCode = dr.getAnimal().get();
            if (animalRepository.existsById(AnimalCode)) {
                throw new EntityNotFoundException("Animal not found with id: " + AnimalCode);
            }
            diary.setAnimal(animalRepository.getReferenceById(AnimalCode));
        }

        dr.getVaccinations().ifPresentOrElse(diary::setVaccinations, () -> diary.setVaccinations(null));
        dr.getAnimal_story().ifPresentOrElse(diary::setAnimal_story, () -> diary.setAnimal_story(null));
        dr.getWealth_status().ifPresentOrElse(diary::setWealth_status, () -> diary.setWealth_status(null));
        dr.getBeahvioral_status().ifPresentOrElse(diary::setBeahvioral_status, () -> diary.setBeahvioral_status(null));
        dr.getOintments_made().ifPresentOrElse(diary::setOintments_made, () -> diary.setOintments_made(null));

        Diary saved = repository.save(diary);
        return saved.getId();
    }

    @Override
    public void update (DiaryRequest dr, int id) {
        Diary diary = repository.findById(id).orElseThrow(EntityNotFoundException::new);

        if (dr.getAnimal() != null && dr.getAnimal().isPresent()) {
            Integer AnimalCode = dr.getAnimal().get();
            if (animalRepository.existsById(AnimalCode)) {
                throw new EntityNotFoundException("Animal not found with id: " + AnimalCode);
            }
            diary.setAnimal(animalRepository.getReferenceById(AnimalCode));
        }

        dr.getVaccinations().ifPresentOrElse(diary::setVaccinations, () -> diary.setVaccinations(null));
        dr.getAnimal_story().ifPresentOrElse(diary::setAnimal_story, () -> diary.setAnimal_story(null));
        dr.getWealth_status().ifPresentOrElse(diary::setWealth_status, () -> diary.setWealth_status(null));
        dr.getBeahvioral_status().ifPresentOrElse(diary::setBeahvioral_status, () -> diary.setBeahvioral_status(null));
        dr.getOintments_made().ifPresentOrElse(diary::setOintments_made, () -> diary.setOintments_made(null));
    }

    @Override
    public void delete (int id) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("Diary not found with id: " + id);
        }
        repository.deleteById(id);
    }

    // ------------------------------------------------------------

    @Override
    public Diary getDiarioByAnimaleId(int idAnimale) {
        return repo_diario.findByAnimaleId(idAnimale);
    }


}











