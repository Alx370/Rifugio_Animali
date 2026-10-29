package com.catarsi.Rifugio_Animali.business.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import com.catarsi.Rifugio_Animali.business.model.enums.Role;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "utente")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "uuid", nullable = false, unique = true, length = 30)
    private String uuid;

    @Column(name = "nome", nullable = false)
    private String firstName;

    @Column(name = "cognome", nullable = false)
    private String lastName;

    @Column(name = "email", nullable = false, unique = true, length = 100)
    private String email;

    @Column(name = "password_hash", nullable = false)
    private String passwordHash;

    @Column(name = "telefono", length = 20)
    private String phone;

    @Column(name = "sesso", length = 1)
    private Character gender;

    @Column(name = "data_nascita")
    private LocalDate birthDate;

    @Column(name = "ruolo", nullable = false, length = 20)
    @Enumerated(EnumType.STRING)
    private Role role = Role.USER;

    @Column(name = "attivo")
    private Boolean active = true;

    @Column(name = "creato_il")
    private LocalDateTime createdAt;

    @Column(name = "aggiornato_il")
    private LocalDateTime updatedAt;

    public User() {}

    @PrePersist
    void prePersist() {
        if (uuid == null || uuid.isBlank()) {
            uuid = UUID.randomUUID().toString().replace("-", "").substring(0, 30);
        }
    }

    public String getPassword() {
        return passwordHash;
    }

    public void setPassword(String password) {
        this.passwordHash = password;
    }

    public void setGender(String gender) {
        this.gender = gender == null || gender.isBlank() ? null : gender.charAt(0);
    }

    public void setGender(Character gender) {
        this.gender = gender;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public void setBirthDate(java.util.Date birthDate) {
        this.birthDate = birthDate == null
                ? null
                : new java.sql.Date(birthDate.getTime()).toLocalDate();
    }

    public Integer getId_utente() {
        return id;
    }

    public void setId_utente(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return firstName;
    }

    public void setNome(String firstName) {
        this.firstName = firstName;
    }

    public String getCognome() {
        return lastName;
    }

    public void setCognome(String lastName) {
        this.lastName = lastName;
    }

    public String getTelefono() {
        return phone;
    }

    public void setTelefono(String phone) {
        this.phone = phone;
    }

    public Character getSesso() {
        return gender;
    }

    public void setSesso(Character gender) {
        this.gender = gender;
    }

    public void setSesso(String gender) {
        setGender(gender);
    }

    public LocalDate getData_nascita() {
        return birthDate;
    }

    public void setData_nascita(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public void setRole(String role) {
        this.role = role == null ? null : Role.valueOf(role);
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getRuolo() {
        return role == null ? null : role.name();
    }

    public void setRuolo(String role) {
        setRole(role);
    }
}
