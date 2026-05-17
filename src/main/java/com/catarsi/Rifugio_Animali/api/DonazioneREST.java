package com.catarsi.Rifugio_Animali.api;

import com.catarsi.Rifugio_Animali.model.Donation;
import com.catarsi.Rifugio_Animali.services.RifugioServiceDonazione;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/donazioni")
public class DonazioneREST {

    @Autowired
    private RifugioServiceDonazione service;

    // GET tutte le donazioni
    @GetMapping
    public List<Donation> getAll() {
        return service.getDonazioni();
    }

    // GET donazione per ID
    @GetMapping("/{id}")
    public Donation getById(@PathVariable int id) {
        return service.getDonazioneById(id);  // serve questo metodo nel service
    }

    // POST nuova donazione
    @PostMapping
    public Donation save(@RequestBody Donation d) {
        return service.addDonazione(d);
    }

    // PUT modifica donazione esistente
    @PutMapping("/{id}")
    public Donation update(@PathVariable int id, @RequestBody Donation nuovo) {
        Donation esistente = service.getDonazioneById(id); // prendo esistente
        if (esistente == null) {
            return null; // o gestisci errore
        }
        // aggiorno campi (esempio, aggiorna quelli che vuoi)
        esistente.setUtente(nuovo.getUtente());
        esistente.setOrganization(nuovo.getOrganization());
        esistente.setData(nuovo.getData());
        esistente.setSomma(nuovo.getSomma());
        return service.addDonazione(esistente); // salvo aggiornato
    }

    // DELETE donazione per ID
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        service.delete(id); // devi avere delete(int id) nel service
    }
}
