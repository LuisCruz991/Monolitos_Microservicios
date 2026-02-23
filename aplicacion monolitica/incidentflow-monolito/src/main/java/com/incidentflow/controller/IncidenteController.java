package com.incidentflow.controller;

import com.incidentflow.model.Incidente;
import com.incidentflow.service.IncidenteService;
import com.incidentflow.dto.IncidenteDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/incidentes")
@CrossOrigin(origins = "*")
public class IncidenteController {

    private final IncidenteService incidenteService;

    public IncidenteController(IncidenteService incidenteService) {
        this.incidenteService = incidenteService;
    }

    @GetMapping
    public List<IncidenteDTO> getAll() {
        return incidenteService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<IncidenteDTO> getIncidenteById(@PathVariable Long id) {
        IncidenteDTO incidente = incidenteService.findById(id);
        return ResponseEntity.ok(incidente);
    }

    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<List<Incidente>> getIncidentesByUsuarioId(
            @PathVariable Long usuarioId) {
        return ResponseEntity.ok(incidenteService.findByUsuarioId(usuarioId));
    }

    @GetMapping("/estado/{estado}")
    public ResponseEntity<List<Incidente>> getIncidentesByEstado(
            @PathVariable String estado) {
        return ResponseEntity.ok(incidenteService.findByEstado(estado));
    }

    @PostMapping
    public ResponseEntity<?> createIncidente(
            @Valid @RequestBody IncidenteDTO incidenteDTO) {

        Incidente incidente = incidenteService.create(incidenteDTO);
        if (incidente == null) {
            return ResponseEntity
                    .badRequest()
                    .body("El usuario especificado no existe");
        }

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(incidente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Incidente> updateIncidente(
            @PathVariable Long id,
            @Valid @RequestBody IncidenteDTO incidenteDTO) {

        Incidente incidente = incidenteService.update(id, incidenteDTO);
        if (incidente == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(incidente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteIncidente(@PathVariable Long id) {
        incidenteService.findById(id);
        incidenteService.delete(id);
        return ResponseEntity.noContent().build();
    }
}