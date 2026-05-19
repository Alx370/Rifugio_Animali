package com.catarsi.Rifugio_Animali.business.services;

import java.util.List;
import com.catarsi.Rifugio_Animali.business.model.Veterinarian;

public interface RifugioServiceDottore {

    Veterinarian addDottore(Veterinarian d);

    List<Veterinarian> getDottori();

    Veterinarian getDottoreById(int id);

    void deleteDottore(int id);
}
