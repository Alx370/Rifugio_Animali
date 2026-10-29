package com.catarsi.Rifugio_Animali.business.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import com.catarsi.Rifugio_Animali.business.model.enums.RequestStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

@Getter
@Setter
@Entity
@Table(name = "visita")
public class Visit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_animale", nullable = false)
    private Animal animal;

    @ManyToOne
    @JoinColumn(name = "id_utente", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "id_dottore")
    private Veterinarian veterinarian;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "data_visita", nullable = false)
    private LocalDate visitDate;

    @Column(name = "tipo_visita", length = 50)
    private String visitType;

    @Column(name = "descrizione", columnDefinition = "TEXT")
    private String description;

    @Column(name = "costo")
    private BigDecimal cost;

    @Column(name = "stato", nullable = false, length = 20)
    @Enumerated(EnumType.STRING)
    private RequestStatus status = RequestStatus.RICHIESTA;

    @Column(name = "creato_il")
    private LocalDateTime createdAt;

    @Column(name = "aggiornato_il")
    private LocalDateTime updatedAt;

    public Visit() {}

    public void setVisitDate(LocalDate visitDate) {
        this.visitDate = visitDate;
    }

    public void setVisitDate(java.util.Date visitDate) {
        this.visitDate = visitDate == null
                ? null
                : new java.sql.Date(visitDate.getTime()).toLocalDate();
    }

    public void setCost(double cost) {
        this.cost = BigDecimal.valueOf(cost);
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }
}
