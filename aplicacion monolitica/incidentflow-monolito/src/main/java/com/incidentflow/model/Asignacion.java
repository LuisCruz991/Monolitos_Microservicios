package com.incidentflow.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Entity
@Table(name = "asignacion")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Asignacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Relación con Incidente
    @OneToOne
    @JoinColumn(name = "incidente_id", nullable = false)
    private Incidente incidente;

    // Relación con Usuario (técnico)
    @ManyToOne
    @JoinColumn(name = "tecnico_id", nullable = false)
    private Usuario tecnico;

    @Column(name = "fecha_asignacion")
    private LocalDate fechaAsignacion;

    @Column(nullable = false)
    private String estado; // ACTIVA, FINALIZADA, CANCELADA
}
