package com.catarsi.Rifugio_Animali.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.catarsi.Rifugio_Animali.model.Diario;
import com.catarsi.Rifugio_Animali.repos.RifugioRepoDiario;

@Service
public class RifugioServiceDiarioImpl implements RifugioServiceDiario{
    
    @Autowired
    private RifugioRepoDiario repo_diario;

    @Override
    public List<Diario> getDiari(){
        return repo_diario.findAll();
    }

    @Override
    public void deleteDiario(int id){
        repo_diario.deleteById(id);
    }

    @Override
    public Diario addDiario(Diario d){
        return repo_diario.save(d);
    }

}







