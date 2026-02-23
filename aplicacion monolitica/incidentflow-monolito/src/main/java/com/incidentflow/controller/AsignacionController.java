package com.incidentflow.controller;

import com.incidentflow.model.Asignacion;
import com.incidentflow.service.AsignacionService;
import com.incidentflow.dto.AsignacionDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/asignaciones")
@CrossOrigin(origins = "*")
public class AsignacionController {

    @Autowired
    private AsignacionService asignacionService;

    @GetMapping
    public ResponseEntity<List<Asignacion>> getAllAsignaciones() {
        return ResponseEntity.ok(asignacionService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Asignacion> getAsignacionById(@PathVariable Long id) {
        Asignacion asignacion = asignacionService.findById(id);
        return asignacion != null ? ResponseEntity.ok(asignacion) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Asignacion> createAsignacion(
            @Valid @RequestBody AsignacionDTO asignacionDTO) {

        Asignacion asignacion = asignacionService.create(asignacionDTO);
        if (asignacion == null) {
            return ResponseEntity.badRequest().build();
        }

        return new ResponseEntity<>(asignacion, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Asignacion> updateAsignacion(
            @PathVariable Long id,
            @Valid @RequestBody AsignacionDTO asignacionDTO) {

        Asignacion asignacion = asignacionService.update(id, asignacionDTO);
        return asignacion != null ? ResponseEntity.ok(asignacion) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAsignacion(@PathVariable Long id) {
        asignacionService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
