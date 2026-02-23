package com.incidentflow.incidentes.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Entity
@Table(name = "incidentes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Incidente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 200)
    private String titulo;

    @Column(length = 1000)
    private String descripcion;

    @Column(nullable = false, length = 20)
    private String prioridad;

    @Column(nullable = false, length = 20)
    private String estado;

    @Column(name = "fecha_creacion")
    private LocalDate fechaCreacion;

    @Column(name = "fecha_actualizacion")
    private LocalDate fechaActualizacion;

    // 🔥 SOLO guardas el ID
    @Column(name = "usuario_id", nullable = false)
    private Long usuarioId;

    @PrePersist
    protected void onCreate() {
        fechaCreacion = LocalDate.now();
        fechaActualizacion = LocalDate.now();
    }

    @PreUpdate
    protected void onUpdate() {
        fechaActualizacion = LocalDate.now();
    }

    public void setNombreUsuario(String nombre) {
    }
}