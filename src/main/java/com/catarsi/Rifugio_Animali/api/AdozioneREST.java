package com.catarsi.Rifugio_Animali.api;

import com.catarsi.Rifugio_Animali.model.Adozione;
import com.catarsi.Rifugio_Animali.services.RifugioServiceAdozione;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/adozioni")
public class AdozioneREST {

    @Autowired
    private RifugioServiceAdozione service;

    @GetMapping
    public List<Adozione> getAll() {
        return service.getAdozioni();
    }

    @PostMapping
    public Adozione create(@RequestBody Adozione a) {
        return service.addAdozione(a);
    }

    @GetMapping("/{id}")
    public Adozione getById(@PathVariable int id) {
        return service.getById(id);
    }

    @PutMapping("/{id}")
    public Adozione update(@PathVariable int id, @RequestBody Adozione aggiornato) {
        Adozione esistente = service.getById(id);

        // aggiorna manualmente i campi
        esistente.setUtente(aggiornato.getUtente());
        esistente.setAnimale(aggiornato.getAnimale());
        esistente.setData_adozione(aggiornato.getData_adozione());
        // aggiungi qui eventuali altri campi da aggiornare

        return service.save(esistente);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        service.delete(id);
    }
}
