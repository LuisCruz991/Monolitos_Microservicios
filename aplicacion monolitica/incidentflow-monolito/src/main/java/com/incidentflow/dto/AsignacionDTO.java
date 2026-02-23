package com.incidentflow.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AsignacionDTO {

    private Long id;

    @NotNull(message = "El incidente es obligatorio")
    private Long incidenteId;

    @NotNull(message = "El técnico es obligatorio")
    private Long tecnicoId;

    @NotBlank(message = "El estado es obligatorio")
    private String estado;

    private String fechaAsignacion;
}
