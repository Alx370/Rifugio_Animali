package com.catarsi.Rifugio_Animali.views.item;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class OrganizationView {
    private Integer id;
    private String name;
    private String email;
    private String telephone;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
