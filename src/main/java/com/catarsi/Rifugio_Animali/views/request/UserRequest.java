package com.catarsi.Rifugio_Animali.views.request;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Optional;

@Getter
@Setter
public class UserRequest {
    private Optional<String> firstName;
    private Optional<String> lastName;
    private Optional<String> email;
    private Optional<String> passwordHash;
    private Optional<String> phone;
    private Optional<Character> gender;
    private Optional<LocalDate> birthDate;
    private Optional<String> role;
    private Optional<Boolean> active;
}
