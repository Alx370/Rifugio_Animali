package com.catarsi.Rifugio_Animali.views.request;

import lombok.Getter;
import lombok.Setter;

import java.util.Optional;

@Getter
@Setter
public class OrganizationRequest {
    private Optional<String> name;
    private Optional<String> email;
    private Optional<String> telephone;
}
