package com.catarsi.Rifugio_Animali.api;

import com.catarsi.Rifugio_Animali.model.Adoption;
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
    public List<Adoption> getAll() {
        return service.getAdozioni();
    }

    @PostMapping
    public Adoption create(@RequestBody Adoption a) {
        return service.addAdozione(a);
    }

    @GetMapping("/{id}")
    public Adoption getById(@PathVariable int id) {
        return service.getById(id);
    }

    @PutMapping("/{id}")
    public Adoption update(@PathVariable int id, @RequestBody Adoption aggiornato) {
        Adoption esistente = service.getById(id);

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
