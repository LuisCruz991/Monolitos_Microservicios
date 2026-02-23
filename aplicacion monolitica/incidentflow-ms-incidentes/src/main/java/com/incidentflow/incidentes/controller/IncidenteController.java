package com.incidentflow.incidentes.controller;

import com.incidentflow.incidentes.model.Incidente;
import com.incidentflow.incidentes.service.IncidenteService;
import com.incidentflow.incidentes.dto.IncidenteDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/incidentes")
@CrossOrigin(origins = "*")
public class IncidenteController {

    @Autowired
    private IncidenteService incidenteService;

    @GetMapping
    public ResponseEntity<List<Incidente>> getAll() {
        return ResponseEntity.ok(incidenteService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Incidente> getById(@PathVariable Long id) {
        Incidente incidente = incidenteService.findById(id);
        return incidente != null ? ResponseEntity.ok(incidente) : ResponseEntity.notFound().build();
    }

    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<List<Incidente>> getByUsuarioId(@PathVariable Long usuarioId) {
        return ResponseEntity.ok(incidenteService.findByUsuarioId(usuarioId));
    }

    @GetMapping("/estado/{estado}")
    public ResponseEntity<List<Incidente>> getByEstado(@PathVariable String estado) {
        return ResponseEntity.ok(incidenteService.findByEstado(estado));
    }

    @GetMapping("/estadisticas/abiertos")
    public ResponseEntity<Long> getIncidentesAbiertos() {
        return ResponseEntity.ok(incidenteService.countIncidentesAbiertos());
    }

    @GetMapping("/rango-fechas")
    public ResponseEntity<List<Incidente>> getByRangoFechas(
            @RequestParam LocalDate inicio,
            @RequestParam LocalDate fin) {
        return ResponseEntity.ok(incidenteService.getIncidentesPorRangoFechas(inicio, fin));
    }

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody IncidenteDTO dto) {
        try {
            Incidente incidente = incidenteService.create(dto);
            return new ResponseEntity<>(incidente, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("❌ " + e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Incidente> update(@PathVariable Long id, @Valid @RequestBody IncidenteDTO dto) {
        Incidente incidente = incidenteService.update(id, dto);
        return incidente != null ? ResponseEntity.ok(incidente) : ResponseEntity.notFound().build();
    }

    @PatchMapping("/{id}/estado")
    public ResponseEntity<Incidente> cambiarEstado(@PathVariable Long id, @RequestParam String estado) {
        IncidenteDTO dto = new IncidenteDTO();
        dto.setEstado(estado);
        Incidente incidente = incidenteService.update(id, dto);
        return incidente != null ? ResponseEntity.ok(incidente) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        incidenteService.delete(id);
        return ResponseEntity.noContent().build();
    }
}