package com.catarsi.Rifugio_Animali.views.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Optional;

@Getter
@Setter
public class UserRegister {
    @NotNull
    private Optional<@NotBlank String> firstName;

    @NotNull
    private Optional<@NotBlank String> lastName;

    @NotNull
    private Optional<@Email String> email;

    @NotNull
    private Optional<@Size(min = 8) String> password;

    private Optional<@Pattern(regexp = "^[0-9+()\\s-]*$") String> phone;
    private Optional<Character> gender;
    private Optional<LocalDate> birthDate;
}
