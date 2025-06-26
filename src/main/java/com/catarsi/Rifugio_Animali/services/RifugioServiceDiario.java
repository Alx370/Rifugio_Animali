package com.catarsi.Rifugio_Animali.services;

import java.util.List;

import com.catarsi.Rifugio_Animali.model.Diario;

public interface RifugioServiceDiario {
    
    Diario addDiario(Diario d);
    void deleteDiario(int id);
    List<Diario> getDiari();
    

    List<Diario> getDiariByAnimaleId(int animaleId);

}
