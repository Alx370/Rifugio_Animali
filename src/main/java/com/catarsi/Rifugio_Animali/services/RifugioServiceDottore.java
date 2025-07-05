package com.catarsi.Rifugio_Animali.services;

import java.util.List;
import com.catarsi.Rifugio_Animali.model.Dottore;

public interface RifugioServiceDottore {

    Dottore addDottore(Dottore d);

    List<Dottore> getDottori();

    Dottore getDottoreById(int id);

    void deleteDottore(int id);
}
