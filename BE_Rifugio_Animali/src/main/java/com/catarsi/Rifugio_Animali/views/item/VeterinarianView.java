package com.catarsi.Rifugio_Animali.views.item;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class VeterinarianView {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private Character gender;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
