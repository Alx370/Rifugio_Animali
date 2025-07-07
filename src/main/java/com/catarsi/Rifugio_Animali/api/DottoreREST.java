package com.catarsi.Rifugio_Animali.api;

import com.catarsi.Rifugio_Animali.model.Dottore;
import com.catarsi.Rifugio_Animali.services.RifugioServiceDottore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/dottori")
public class DottoreREST {

    @Autowired
    private RifugioServiceDottore service;

    // GET /api/dottori
    @GetMapping
    public List<Dottore> getAllDottori() {
        return service.getDottori();
    }

    // GET /api/dottori/{id}
    @GetMapping("/{id}")
    public Dottore getDottoreById(@PathVariable int id) {
        return service.getDottoreById(id);
    }

    // POST /api/dottori
    @PostMapping
    public Dottore createDottore(@RequestBody Dottore dottore) {
        return service.addDottore(dottore);
    }

    // DELETE /api/dottori/{id}
    @DeleteMapping("/{id}")
    public void deleteDottore(@PathVariable int id) {
        service.deleteDottore(id);
    }

    // PUT /api/dottori/{id}
    @PutMapping("/{id}")
    public Dottore updateDottore(@PathVariable int id, @RequestBody Dottore aggiornato) {
        Dottore esistente = service.getDottoreById(id);
        esistente.setNome(aggiornato.getNome());
        esistente.setCognome(aggiornato.getCognome());
        esistente.setEmail(aggiornato.getEmail());
        esistente.setTelefono(aggiornato.getTelefono());
        esistente.setSesso(aggiornato.getSesso());
        return service.addDottore(esistente);
    }
}
