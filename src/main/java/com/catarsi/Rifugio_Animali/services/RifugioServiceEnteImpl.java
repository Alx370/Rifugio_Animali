package com.catarsi.Rifugio_Animali.services;

import com.catarsi.Rifugio_Animali.model.Organization;
import com.catarsi.Rifugio_Animali.repos.RifugioRepoEnte;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service // Indica che questa classe è un service Spring
public class RifugioServiceEnteImpl implements RifugioServiceEnte {

    private final RifugioRepoEnte repo;

    public RifugioServiceEnteImpl(RifugioRepoEnte repo) {
        this.repo = repo;
    }

    @Override
    public List<Organization> getAllEnti() {
        return repo.findAll();
    }

    @Override
    public Organization getEnteById(int id) {
        Optional<Organization> ente = repo.findById(id);
        return ente.orElse(null);
    }

    @Override
    public Organization addEnte(Organization organization) {
       return repo.save(organization);
    }

    @Override
    public void delete(int id) {
        repo.deleteById(id);
    }
//
//    @Autowired
//    private RifugioRepoEnte enteRepo;
//
//    /**
//     * Salva o aggiorna un Ente nel database.
//     * @param e oggetto Ente da salvare
//     * @return Ente salvato
//     */
//    @Override
//    public Ente save(Ente e) {
//        return enteRepo.save(e);
//    }
//
//    /**
//     * Recupera tutti gli enti dal database.
//     * @return lista di enti
//     */
//    @Override
//    public List<Ente> getAll() {
//        return enteRepo.findAll();
//    }
//
//    /**
//     * Recupera un ente tramite il suo ID.
//     * @param id identificativo dell’ente
//     * @return Ente se presente, altrimenti null
//     */
//    @Override
//    public Ente getById(Integer id) {
//        Optional<Ente> ente = enteRepo.findById(id);
//        return ente.orElse(null); // Oppure lancia eccezione personalizzata
//    }
//
//    /**
//     * Elimina un ente tramite ID, se esiste.
//     * @param id identificativo dell’ente da eliminare
//     */
//    @Override
//    public void delete(Integer id) {
//        if (enteRepo.existsById(id)) {
//            enteRepo.deleteById(id);
//        } else {
//            // In alternativa, puoi lanciare un'eccezione
//            System.out.println("Nessun ente trovato con ID: " + id);
//        }
//
//

}
