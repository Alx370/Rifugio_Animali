package com.catarsi.Rifugio_Animali.services;

import com.catarsi.Rifugio_Animali.model.Animale;
import com.catarsi.Rifugio_Animali.repos.RifugioRepoAnimale;
import com.catarsi.Rifugio_Animali.repos.RifugioRepoDiario;
import com.catarsi.Rifugio_Animali.repos.RifugioRepoVisita;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.data.jpa.domain.Specification;

import java.util.List;

@Service
public class RifugioServiceAnimaliImpl implements RifugioServiceAnimali {

    @Autowired
    private RifugioRepoAnimale animali_repo;

    @Autowired
    private RifugioRepoDiario diarioRepo;

    @Autowired
    private RifugioRepoVisita visitaRepo;

    @Override
    public Animale addAnimale(Animale a) {
        return animali_repo.save(a);
    }

    @Override
    public void deleteAnimale(int id) {
        visitaRepo.deleteByAnimaleId(id);
        diarioRepo.deleteByAnimaleId(id);
        animali_repo.deleteById(id);
    }

    @Override
    public List<Animale> getAnimali() {
        return animali_repo.findAll();
    }

    @Override
    public Animale getAnimaleByIdAnimale(int id) {
        return animali_repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Animale non trovato con ID: " + id));
    }

    @Override
    public Specification<Animale> nomeContains(String nome) {
        return (root, query, cb) ->
                nome == null || nome.isEmpty() ? null : cb.like(cb.lower(root.get("nome")), "%" + nome.toLowerCase() + "%");
    }

    @Override
    public Specification<Animale> sessoEquals(String sesso) {
        return (root, query, cb) ->
                sesso == null || sesso.isEmpty() ? null : cb.equal(root.get("sesso"), sesso);
    }

    @Override
    public Specification<Animale> specieEquals(String specie) {
        return (root, query, cb) ->
                specie == null || specie.isEmpty() ? null : cb.equal(root.get("specie"), specie);
    }

    @Override
    public Specification<Animale> razzaContains(String razza) {
        return (root, query, cb) ->
                razza == null || razza.isEmpty() ? null : cb.like(cb.lower(root.get("razza")), "%" + razza.toLowerCase() + "%");
    }

    @Override
    public Specification<Animale> pesoLessOrEqual(Double peso) {
        return (root, query, cb) ->
                peso == null ? null : cb.lessThanOrEqualTo(root.get("peso"), peso);
    }

    @Override
    public Specification<Animale> etaLessOrEqual(Integer eta) {
        return (root, query, cb) ->
                eta == null ? null : cb.lessThanOrEqualTo(root.get("eta"), eta);
    }

    public List<Animale> filtraAnimali(String nome, String sesso, String specie, String razza, Double peso, Integer eta) {
        Specification<Animale> spec = null;

        if (nome != null && !nome.isEmpty()) {
            spec = (spec == null) ? this.nomeContains(nome) : spec.and(this.nomeContains(nome));
        }
        if (sesso != null && !sesso.isEmpty()) {
            spec = (spec == null) ? this.sessoEquals(sesso) : spec.and(this.sessoEquals(sesso));
        }
        if (specie != null && !specie.isEmpty()) {
            spec = (spec == null) ? this.specieEquals(specie) : spec.and(this.specieEquals(specie));
        }
        if (razza != null && !razza.isEmpty()) {
            spec = (spec == null) ? this.razzaContains(razza) : spec.and(this.razzaContains(razza));
        }
        if (peso != null) {
            spec = (spec == null) ? this.pesoLessOrEqual(peso) : spec.and(this.pesoLessOrEqual(peso));
        }
        if (eta != null) {
            spec = (spec == null) ? this.etaLessOrEqual(eta) : spec.and(this.etaLessOrEqual(eta));
        }

        if (spec == null) {
            return animali_repo.findAll();
        } else {
            return animali_repo.findAll(spec);
        }
    }

}






