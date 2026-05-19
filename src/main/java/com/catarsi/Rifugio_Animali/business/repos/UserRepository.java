package com.catarsi.Rifugio_Animali.business.repos;

import java.util.Optional;

import com.catarsi.Rifugio_Animali.business.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByEmail(String email);
}
