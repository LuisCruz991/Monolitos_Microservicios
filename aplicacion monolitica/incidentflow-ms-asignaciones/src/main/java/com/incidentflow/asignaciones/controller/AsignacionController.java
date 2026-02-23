package com.incidentflow.asignaciones.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.incidentflow.asignaciones.model.Asignacion;
import com.incidentflow.asignaciones.repository.AsignacionRepository;

@RestController
@RequestMapping("/asignacion")
public class AsignacionController {

    @Autowired
    private AsignacionRepository repository;

    @GetMapping
    public List<Asignacion> listar() {
        return repository.findAll();
    }

    @SuppressWarnings("null")
    @GetMapping("/{id}")
    public Asignacion obtenerPorId(@PathVariable Long id) {
        return repository.findById(id).orElse(null);
    }
}