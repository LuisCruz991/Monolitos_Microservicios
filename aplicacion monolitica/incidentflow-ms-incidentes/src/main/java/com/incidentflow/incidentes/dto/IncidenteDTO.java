package com.incidentflow.incidentes.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;

@Data
public class IncidenteDTO {
    private Long id;

    @NotBlank(message = "El título es obligatorio")
    @Size(min = 3, max = 200, message = "El título debe tener entre 3 y 200 caracteres")
    private String titulo;

    @Size(max = 1000, message = "La descripción no puede exceder 1000 caracteres")
    private String descripcion;

    @NotBlank(message = "La prioridad es obligatoria")
    private String prioridad;

    private String estado;

    @NotNull(message = "El ID del usuario es obligatorio")
    private Long usuarioId;

    public void setFechaCreacion(LocalDate fechaCreacion) {
    }
}