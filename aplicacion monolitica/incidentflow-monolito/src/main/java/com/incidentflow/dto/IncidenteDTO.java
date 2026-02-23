package com.incidentflow.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.time.LocalDate;

@Data
public class IncidenteDTO {
    private Long id;
    
    @NotBlank(message = "El título es obligatorio")
    private String titulo;
    
    private String descripcion;
    
    @NotBlank(message = "La prioridad es obligatoria")
    private String prioridad;
    
    @NotBlank(message = "El estado es obligatorio")
    private String estado;

    @NotNull(message = "El ID del usuario es obligatorio")
    private Long usuarioId;

    private String usuarioNombre;

    private LocalDate fechaCreacion;
}