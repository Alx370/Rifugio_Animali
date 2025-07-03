package com.catarsi.Rifugio_Animali.api;

import com.catarsi.Rifugio_Animali.model.Visita;
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
    public List<Visita> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Visita getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public Visita create(@RequestBody Visita visita) {
        return service.save(visita);
    }

    @PutMapping("/{id}")
    public Visita update(@PathVariable Long id, @RequestBody Visita aggiornato) {
        Visita esistente = service.getById(id);

        // Aggiorna manualmente i campi di Visita
        esistente.setData(aggiornato.getData());
        esistente.setDescrizione(aggiornato.getDescrizione());
        esistente.setDottore(aggiornato.getDottore());
        esistente.setAnimale(aggiornato.getAnimale());
        // aggiungi altri campi se ci sono

        return service.save(esistente);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
