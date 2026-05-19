package com.catarsi.Rifugio_Animali.api;

import com.catarsi.Rifugio_Animali.business.services.UserService;
import com.catarsi.Rifugio_Animali.views.item.UserView;
import com.catarsi.Rifugio_Animali.views.request.UserRequest;
import jakarta.annotation.security.RolesAllowed;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
@RequestMapping("/users")
public class UsersController {

    private final UserService userService;

    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @RolesAllowed({"ADMIN"})
    @GetMapping
    public Page<UserView> findAll(Pageable pageable) {
        return userService.findAll(pageable);
    }

    @RolesAllowed({"ADMIN"})
    @GetMapping("/{id}")
    public UserView findById(@PathVariable int id) {
        return userService.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found for id=" + id));
    }

    @RolesAllowed({"ADMIN"})
    @PostMapping
    public int create(@RequestBody UserRequest userRequest) {
        return userService.create(userRequest);
    }

    @RolesAllowed({"ADMIN"})
    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable int id, @RequestBody UserRequest userRequest) {
        userService.update(userRequest, id);
    }

    @RolesAllowed({"ADMIN"})
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        userService.delete(id);
    }
}
