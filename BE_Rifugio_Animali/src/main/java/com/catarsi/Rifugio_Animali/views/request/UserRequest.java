package com.catarsi.Rifugio_Animali.views.request;

import com.catarsi.Rifugio_Animali.business.model.enums.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Optional;

@Getter
@Setter
public class UserRequest {
    private Optional<@NotBlank String> firstName;
    private Optional<@NotBlank String> lastName;
    private Optional<@Email String> email;
    private Optional<@Size(min = 8) String> password;
    private Optional<@Pattern(regexp = "^[0-9+()\\s-]*$") String> phone;
    private Optional<Character> gender;
    private Optional<LocalDate> birthDate;
    private Optional<Role> role;
    private Optional<Boolean> active;
}
