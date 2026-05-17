package com.catarsi.Rifugio_Animali.model;

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

    @Column(name = "data", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate data;

    @Column(name = "somma", nullable = false)
    private BigDecimal sum;

    @Column(name = "created_at")
    private LocalDateTime created_at;

    @Column(name = "updated_at")
    private LocalDateTime updated_at;

    public double getSomma() {
        return sum == null ? 0.0 : sum.doubleValue();
    }

    public void setSomma(double somma) {
        this.sum = BigDecimal.valueOf(somma);
    }

    public void setSomma(BigDecimal somma) {
        this.sum = somma;
    }
}
