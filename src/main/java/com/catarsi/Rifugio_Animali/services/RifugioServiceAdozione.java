package com.catarsi.Rifugio_Animali.services;

import java.util.List;
import com.catarsi.Rifugio_Animali.model.Adozione;
import com.catarsi.Rifugio_Animali.model.Animale;

public interface RifugioServiceAdozione {

    Adozione addAdozione(Adozione a);

	Adozione save(Adozione a);

    List<Adozione> getAdozioni();

    Adozione getById(int id);

    void delete(int id);

    Adozione getAdozioneById(int id);

    Animale aggiungiDataAdozione(Adozione a);
}
