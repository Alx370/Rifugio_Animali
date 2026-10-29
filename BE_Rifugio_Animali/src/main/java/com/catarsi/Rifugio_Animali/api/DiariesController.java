package com.catarsi.Rifugio_Animali.api;

import com.catarsi.Rifugio_Animali.business.services.DiaryService;
import com.catarsi.Rifugio_Animali.views.item.DiaryView;
import com.catarsi.Rifugio_Animali.views.request.DiaryRequest;
import jakarta.annotation.security.RolesAllowed;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/diaries")
public class DiariesController {

    private final DiaryService srvDiario;

    public DiariesController(DiaryService srvDiario) {
        this.srvDiario = srvDiario;
    }

    @RolesAllowed( {"USER", "ADMIN"})
    @GetMapping
    public Page<DiaryView> findAll(Pageable pageable) {
        return srvDiario.findAll(pageable);
    }

    @RolesAllowed( {"USER", "ADMIN"})
    @GetMapping("/{id}")
    public DiaryView findById(@PathVariable int id) {
        return srvDiario.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Diary not found for id=" + id));
    }

    @RolesAllowed({"USER", "ADMIN"})
    @PostMapping
    public int create (@RequestBody DiaryRequest dr) {
        return srvDiario.create(dr);
    }

    @RolesAllowed({"USER", "ADMIN"})
    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable int id, @RequestBody DiaryRequest dr) {
        srvDiario.update(dr, id);
    }

    @RolesAllowed("ADMIN")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        srvDiario.delete(id);
    }
}

