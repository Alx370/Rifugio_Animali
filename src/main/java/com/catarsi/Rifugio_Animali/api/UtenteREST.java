package com.catarsi.Rifugio_Animali.api;

import com.catarsi.Rifugio_Animali.model.User;
import com.catarsi.Rifugio_Animali.model.User;
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
    public List<User> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable Integer id) {
        return service.getById(id);
    }

    @PostMapping
    public User create(@RequestBody User user) {
        return service.save(user);
    }

    @PutMapping("/{id}")
    public User update(@PathVariable Integer id, @RequestBody User aggiornato) {
        User esistente = service.getById(id);

        // aggiorna manualmente i campi
        esistente.setNome(aggiornato.getNome());
        esistente.setCognome(aggiornato.getCognome());
        esistente.setEmail(aggiornato.getEmail());
        esistente.setTelefono(aggiornato.getTelefono());
        // aggiungi altri campi se ce ne sono

        return service.save(esistente);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }
}
