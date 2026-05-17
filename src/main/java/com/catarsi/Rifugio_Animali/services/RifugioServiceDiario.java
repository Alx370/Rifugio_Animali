package com.catarsi.Rifugio_Animali.services;

import java.util.List;

import com.catarsi.Rifugio_Animali.model.Diary;

public interface RifugioServiceDiario {
    
    Diary addDiario(Diary d);
    void deleteDiario(int id);
    List<Diary> getDiari();
    Diary getDiarioById(int id);

    List<Diary> getDiariByAnimaleId(int animaleId);

    Diary getDiarioByAnimaleId(int idAnimale);
}
