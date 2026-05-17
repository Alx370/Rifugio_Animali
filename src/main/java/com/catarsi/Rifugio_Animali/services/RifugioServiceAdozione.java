package com.catarsi.Rifugio_Animali.services;

import java.util.List;

import com.catarsi.Rifugio_Animali.model.Adoption;
import com.catarsi.Rifugio_Animali.model.Animal;
import com.catarsi.Rifugio_Animali.model.Animal;

public interface RifugioServiceAdozione {

    Adoption addAdozione(Adoption a);

	Adoption save(Adoption a);

    List<Adoption> getAdozioni();

    Adoption getById(int id);

    void delete(int id);

    Adoption getAdozioneById(int id);

    Animal aggiungiDataAdozione(Adoption a);
}
