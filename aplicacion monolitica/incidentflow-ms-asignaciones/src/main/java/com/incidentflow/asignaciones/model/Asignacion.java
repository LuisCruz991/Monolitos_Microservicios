package com.incidentflow.asignaciones.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "asignacion")
@Data
public class Asignacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String incidente;
    private String usuario;

    @Column(name = "fecha")
    private LocalDateTime fecha;

    private String estado;
}
