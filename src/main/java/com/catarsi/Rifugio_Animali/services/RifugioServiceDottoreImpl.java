package com.catarsi.Rifugio_Animali.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.catarsi.Rifugio_Animali.model.Dottore;
import com.catarsi.Rifugio_Animali.repos.RifugioRepoDottore;

@Service
public class RifugioServiceDottoreImpl implements RifugioServiceDottore{
    
    @Autowired
    private RifugioRepoDottore repo_dottore;

    @Override
    public List<Dottore> getDottori(){
        return repo_dottore.findAll();
    }

    @Override 
    public Dottore addDottore(Dottore d){
        return repo_dottore.save(d);
    }

}










