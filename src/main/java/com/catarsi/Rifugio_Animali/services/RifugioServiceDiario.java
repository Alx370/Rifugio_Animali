package com.catarsi.Rifugio_Animali.services;

import java.util.List;

import com.catarsi.Rifugio_Animali.model.Diario;

public interface RifugioServiceDiario {
    
    Diario getDiario(Diario d);
    List<Diario> addDiari();
    
}
