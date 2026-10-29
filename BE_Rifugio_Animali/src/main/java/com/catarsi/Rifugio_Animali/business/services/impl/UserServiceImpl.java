package com.catarsi.Rifugio_Animali.business.services.impl;

import com.catarsi.Rifugio_Animali.business.model.User;
import com.catarsi.Rifugio_Animali.business.model.enums.Role;
import com.catarsi.Rifugio_Animali.business.repos.UserRepository;
import com.catarsi.Rifugio_Animali.business.services.UserService;
import com.catarsi.Rifugio_Animali.views.item.UserView;
import com.catarsi.Rifugio_Animali.views.request.UserRegister;
import com.catarsi.Rifugio_Animali.views.request.UserRequest;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    private final ModelMapper mapper;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository repository, ModelMapper mapper, PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.mapper = mapper;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Page<UserView> findAll(Pageable pageable) {
        return repository.findAll(pageable)
                .map(user -> mapper.map(user, UserView.class));
    }

    @Override
    public Optional<UserView> findById(int id) {
        return repository.findById(id)
                .map(user -> mapper.map(user, UserView.class));
    }

    @Override
    public int register(UserRegister userRegister) {
        User user = new User();

        userRegister.getFirstName().ifPresentOrElse(user::setFirstName, () -> user.setFirstName(null));
        userRegister.getLastName().ifPresentOrElse(user::setLastName, () -> user.setLastName(null));
        userRegister.getEmail().ifPresentOrElse(user::setEmail, () -> user.setEmail(null));
        userRegister.getPassword().ifPresentOrElse(password -> user.setPasswordHash(passwordEncoder.encode(password)), () -> user.setPasswordHash(null));
        userRegister.getPhone().ifPresentOrElse(user::setPhone, () -> user.setPhone(null));
        userRegister.getGender().ifPresentOrElse(user::setGender, () -> user.setGender((Character) null));
        userRegister.getBirthDate().ifPresentOrElse(user::setBirthDate, () -> user.setBirthDate((java.time.LocalDate) null));
        user.setRole(Role.USER);
        user.setActive(true);

        User saved = repository.save(user);
        return saved.getId();
    }

    @Override
    public int create(UserRequest userRequest) {
        User user = new User();

        userRequest.getFirstName().ifPresentOrElse(user::setFirstName, () -> user.setFirstName(null));
        userRequest.getLastName().ifPresentOrElse(user::setLastName, () -> user.setLastName(null));
        userRequest.getEmail().ifPresentOrElse(user::setEmail, () -> user.setEmail(null));
        userRequest.getPassword().ifPresentOrElse(password -> user.setPasswordHash(passwordEncoder.encode(password)), () -> user.setPasswordHash(null));
        userRequest.getPhone().ifPresentOrElse(user::setPhone, () -> user.setPhone(null));
        userRequest.getGender().ifPresentOrElse(user::setGender, () -> user.setGender((Character) null));
        userRequest.getBirthDate().ifPresentOrElse(user::setBirthDate, () -> user.setBirthDate((java.time.LocalDate) null));
        userRequest.getRole().ifPresentOrElse(user::setRole, () -> user.setRole(Role.USER));
        userRequest.getActive().ifPresentOrElse(user::setActive, () -> user.setActive(true));

        User saved = repository.save(user);
        return saved.getId();
    }

    @Override
    public void update(UserRequest userRequest, int id) {
        User user = repository.findById(id).orElseThrow(EntityNotFoundException::new);

        userRequest.getFirstName().ifPresent(user::setFirstName);
        userRequest.getLastName().ifPresent(user::setLastName);
        userRequest.getEmail().ifPresent(user::setEmail);
        userRequest.getPassword().ifPresent(password -> user.setPasswordHash(passwordEncoder.encode(password)));
        userRequest.getPhone().ifPresent(user::setPhone);
        userRequest.getGender().ifPresent(user::setGender);
        userRequest.getBirthDate().ifPresent(user::setBirthDate);
        userRequest.getRole().ifPresent(user::setRole);
        userRequest.getActive().ifPresent(user::setActive);

        repository.save(user);
    }

    @Override
    public void delete(int id) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("User not found with id: " + id);
        }
        repository.deleteById(id);
    }

    public List<User> findAllUsers() {
        return repository.findAll();
    }
}
