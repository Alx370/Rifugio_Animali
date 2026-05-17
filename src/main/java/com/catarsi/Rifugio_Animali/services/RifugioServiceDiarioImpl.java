package com.catarsi.Rifugio_Animali.services;

import java.util.List;

import com.catarsi.Rifugio_Animali.model.Diary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.catarsi.Rifugio_Animali.repos.RifugioRepoDiario;

@Service
public class RifugioServiceDiarioImpl implements RifugioServiceDiario{
    
    @Autowired
    private RifugioRepoDiario repo_diario;

    @Override
    public List<Diary> getDiari(){
        return repo_diario.findAll();
    }

    @Override
    public void deleteDiario(int id){
        repo_diario.deleteById(id);
    }

    @Override
    public Diary addDiario(Diary d){
        return repo_diario.save(d);
    }

    @Override
    public List<Diary> getDiariByAnimaleId(int animaleId){
        return repo_diario.findAll().stream()
                .filter(diario -> diario.getAnimal().getId_animale() == animaleId)
                .toList();
    }

    @Override
    public Diary getDiarioById(int id){
        return repo_diario.findById(id)
                .orElseThrow(() -> new RuntimeException("Diario non trovato con ID: " + id));
    }

    @Override
    public Diary getDiarioByAnimaleId(int idAnimale) {
        return repo_diario.findByAnimaleId(idAnimale);
    }


}











