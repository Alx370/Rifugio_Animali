package com.catarsi.Rifugio_Animali.api;

import com.catarsi.Rifugio_Animali.model.Animale;
import com.catarsi.Rifugio_Animali.services.RifugioServiceAnimali;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/animali")
public class AnimaliREST {

    @Autowired
    private RifugioServiceAnimali srv;

    @GetMapping
    public List<Animale> getAllAnimali() {
        return srv.getAnimali();
    }

    @GetMapping("/{id}")
    public Animale getAnimaleById(@PathVariable int id) {
        return srv.getAnimaleByIdAnimale(id);
    }

    @PostMapping
    public Animale createAnimale(@RequestBody Animale animale) {
        return srv.addAnimale(animale);
    }

    @DeleteMapping("/{id}")
    public void deleteAnimale(@PathVariable int id) {
        srv.deleteAnimale(id);
    }

    @PutMapping("/{id}")
    public Animale updateAnimale(@PathVariable int id, @RequestBody Animale aggiornato) {
        Animale esistente = srv.getAnimaleByIdAnimale(id);
        esistente.setSpecie(aggiornato.getSpecie());
        esistente.setRazza(aggiornato.getRazza());
        esistente.setPeso(aggiornato.getPeso());
        esistente.setEta(aggiornato.getEta());
        return srv.addAnimale(esistente);
    }
}
