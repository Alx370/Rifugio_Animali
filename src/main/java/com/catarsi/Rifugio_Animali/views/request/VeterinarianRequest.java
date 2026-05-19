package com.catarsi.Rifugio_Animali.views.request;

import lombok.Getter;
import lombok.Setter;

import java.util.Optional;

@Getter
@Setter
public class VeterinarianRequest {
    private Optional<String> firstName;
    private Optional<String> lastName;
    private Optional<String> email;
    private Optional<String> phone;
    private Optional<Character> gender;
}
