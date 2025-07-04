package com.catarsi.Rifugio_Animali.services;

import com.catarsi.Rifugio_Animali.model.Ente;
import com.catarsi.Rifugio_Animali.repos.RifugioRepoEnte;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service // Indica che questa classe è un service Spring
public class RifugioServiceEnteImpl implements RifugioServiceEnte {

    @Autowired
    private RifugioRepoEnte enteRepo;

    /**
     * Salva o aggiorna un Ente nel database.
     * @param e oggetto Ente da salvare
     * @return Ente salvato
     */
    @Override
    public Ente save(Ente e) {
        return enteRepo.save(e);
    }

    /**
     * Recupera tutti gli enti dal database.
     * @return lista di enti
     */
    @Override
    public List<Ente> getAll() {
        return enteRepo.findAll();
    }

    /**
     * Recupera un ente tramite il suo ID.
     * @param id identificativo dell’ente
     * @return Ente se presente, altrimenti null
     */
    @Override
    public Ente getById(Integer id) {
        Optional<Ente> ente = enteRepo.findById(id);
        return ente.orElse(null); // Oppure lancia eccezione personalizzata
    }

    /**
     * Elimina un ente tramite ID, se esiste.
     * @param id identificativo dell’ente da eliminare
     */
    @Override
    public void delete(Integer id) {
        if (enteRepo.existsById(id)) {
            enteRepo.deleteById(id);
        } else {
            // In alternativa, puoi lanciare un'eccezione
            System.out.println("Nessun ente trovato con ID: " + id);
        }
    }
}
