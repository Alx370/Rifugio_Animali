package com.catarsi.Rifugio_Animali.api;

import com.catarsi.Rifugio_Animali.model.Utente;
import com.catarsi.Rifugio_Animali.services.RifugioServiceUtente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/utenti")
public class UtenteREST {

    @Autowired
    private RifugioServiceUtente service;

    @GetMapping
    public List<Utente> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Utente getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public Utente create(@RequestBody Utente utente) {
        return service.save(utente);
    }

    @PutMapping("/{id}")
    public Utente update(@PathVariable Long id, @RequestBody Utente aggiornato) {
        Utente esistente = service.getById(id);

        // aggiorna manualmente i campi
        esistente.setNome(aggiornato.getNome());
        esistente.setCognome(aggiornato.getCognome());
        esistente.setEmail(aggiornato.getEmail());
        esistente.setTelefono(aggiornato.getTelefono());
        // aggiungi altri campi se ce ne sono

        return service.save(esistente);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
