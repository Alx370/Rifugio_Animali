package com.catarsi.Rifugio_Animali.business.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "donazione")
public class Donation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_utente")
    private User user;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_ente", nullable = false)
    private Organization organization;

    @Column(name = "data_donazione", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;

    @Column(name = "somma", nullable = false)
    private BigDecimal sum;

    @Column(name = "creato_il")
    private LocalDateTime createdAt;

    @Column(name = "aggiornato_il")
    private LocalDateTime updatedAt;

    public User getUtente() {
        return user;
    }

    public void setUtente(User user) {
        this.user = user;
    }

    public LocalDate getData() {
        return date;
    }

    public void setData(LocalDate date) {
        this.date = date;
    }

    public BigDecimal getSomma() {
        return sum;
    }

    public void setSomma(BigDecimal sum) {
        this.sum = sum;
    }

    public void setSomma(double sum) {
        this.sum = BigDecimal.valueOf(sum);
    }
}
