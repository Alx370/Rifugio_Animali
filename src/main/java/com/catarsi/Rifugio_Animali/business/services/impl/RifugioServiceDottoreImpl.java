package com.catarsi.Rifugio_Animali.business.services.impl;

import java.util.List;

import com.catarsi.Rifugio_Animali.business.model.Veterinarian;
import com.catarsi.Rifugio_Animali.business.services.RifugioServiceDottore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.catarsi.Rifugio_Animali.business.repos.RifugioRepoDottore;

@Service
public class RifugioServiceDottoreImpl implements RifugioServiceDottore {
    
    @Autowired
    private RifugioRepoDottore repo_dottore;

    @Override
    public List<Veterinarian> getDottori(){
        return repo_dottore.findAll();
    }

    @Override 
    public Veterinarian addDottore(Veterinarian d){
        return repo_dottore.save(d);
    }

    @Override
    public Veterinarian getDottoreById(int id) {
        return repo_dottore.findById(id).orElse(null); 
    }

    @Override
    public void deleteDottore(int id) {
        repo_dottore.deleteById(id); 
    }



}










