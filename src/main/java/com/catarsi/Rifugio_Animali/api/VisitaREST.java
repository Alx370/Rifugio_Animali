package com.catarsi.Rifugio_Animali.api;

import com.catarsi.Rifugio_Animali.model.Visit;
import com.catarsi.Rifugio_Animali.services.RifugioServicesVisita;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/visite")
public class VisitaREST {

    @Autowired
    private RifugioServicesVisita service;

    @GetMapping
    public List<Visit> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Visit getById(@PathVariable Integer id) {
        return service.getById(id);
    }

    @PostMapping
    public Visit create(@RequestBody Visit visit) {
        return service.save(visit);
    }

    @PutMapping("/{id}")
    public Visit update(@PathVariable Integer id, @RequestBody Visit aggiornato) {
        Visit esistente = service.getById(id);

        // Aggiorna manualmente i campi di Visita
        esistente.setData_visita (aggiornato.getData_visita());
        esistente.setDescrizione(aggiornato.getDescrizione());
        esistente.setDottore(aggiornato.getDottore());
        esistente.setAnimale(aggiornato.getAnimale());
        // aggiungi altri campi se ci sono

        return service.save(esistente);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }
}
