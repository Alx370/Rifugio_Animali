package com.catarsi.Rifugio_Animali.business.services;

import com.catarsi.Rifugio_Animali.views.item.UserView;
import com.catarsi.Rifugio_Animali.views.request.UserRegister;
import com.catarsi.Rifugio_Animali.views.request.UserRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface UserService {
    Page<UserView> findAll(Pageable pageable);
    Optional<UserView> findById(int id);
    int register(UserRegister userRegister);
    int create(UserRequest userRequest);
    void update(UserRequest userRequest, int id);
    void delete(int id);
}
