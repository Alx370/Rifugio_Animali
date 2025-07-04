package com.catarsi.Rifugio_Animali.api;

import com.catarsi.Rifugio_Animali.model.Ente;
import com.catarsi.Rifugio_Animali.services.RifugioServiceEnte;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/enti")
public class EnteREST {

    @Autowired
    private RifugioServiceEnte service;

    @GetMapping
    public List<Ente> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Ente getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public Ente create(@RequestBody Ente ente) {
        return service.save(ente);
    }

    @PutMapping("/{id}")
    public Ente update(@PathVariable Long id, @RequestBody Ente aggiornato) {
        Ente esistente = service.getById(id);

        // aggiorna manualmente i campi dell'ente
        esistente.setNome(aggiornato.getNome());
        
        esistente.setEmail(aggiornato.getEmail());
        esistente.setTelefono(aggiornato.getTelefono());
        // aggiungi altri campi se ci sono

        return service.save(esistente);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
