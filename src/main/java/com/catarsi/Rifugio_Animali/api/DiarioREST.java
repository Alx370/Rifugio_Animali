package com.catarsi.Rifugio_Animali.api;

import com.catarsi.Rifugio_Animali.model.Diario;
import com.catarsi.Rifugio_Animali.services.RifugioServiceDiario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/diari")
public class DiarioREST {

    @Autowired
    private RifugioServiceDiario srv;

    @GetMapping
    public List<Diario> getAllDiari() {
        return srv.getDiari();
    }

    @GetMapping("/{id}")
    public List<Diario> getDiarioById(@PathVariable int id) {
        return srv.getDiariByAnimaleId(id);
    }

    @PostMapping
    public Diario createDiario(@RequestBody Diario diario) {
        return srv.addDiario(diario);
    }

    @DeleteMapping("/{id}")
    public void deleteDiario(@PathVariable int id) {
        srv.deleteDiario(id);
    }

    @PutMapping("/{id}")
    public Diario updateDiario(@PathVariable int id, @RequestBody Diario aggiornato) {
        List<Diario> diari = srv.getDiariByAnimaleId(id);
        if (diari.isEmpty()) throw new RuntimeException("Nessun diario trovato per animale ID: " + id);

        Diario esistente = diari.get(0); // oppure cerca l’id preciso se ne hai più
        esistente.setStoria_animale(aggiornato.getStoria_animale());
        esistente.setStato_salute(aggiornato.getStato_salute());
        esistente.setStato_comportamentale(aggiornato.getStato_comportamentale());
        esistente.setVaccinazioni(aggiornato.getVaccinazioni());
        esistente.setOperazioni_effettuate(aggiornato.getOperazioni_effettuate());

        return srv.addDiario(esistente);
    }
}



