package com.catarsi.Rifugio_Animali.views.item;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class UserView {
    private Integer id;
    private String uuid;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private Character gender;
    private LocalDate birthDate;
    private String role;
    private Boolean active;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
