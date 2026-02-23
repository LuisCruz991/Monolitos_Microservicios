package com.incidentflow.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.incidentflow.dto.AsignacionDTO;
import com.incidentflow.model.Asignacion;
import com.incidentflow.model.Incidente;
import com.incidentflow.model.Usuario;
import com.incidentflow.repository.AsignacionRepository;
import com.incidentflow.repository.IncidenteRepository;
import com.incidentflow.repository.UsuarioRepository;

@Service
public class AsignacionService {

    @Autowired
    private AsignacionRepository asignacionRepository;

    @Autowired
    private IncidenteRepository incidenteRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Asignacion> findAll() {
        return asignacionRepository.findAll();
    }

    public Asignacion findById(Long id) {
        return asignacionRepository.findById(id).orElse(null);
    }

    public Asignacion create(AsignacionDTO dto) {

        Incidente incidente = incidenteRepository
                .findById(dto.getIncidenteId())
                .orElse(null);

        Usuario tecnico = usuarioRepository
                .findById(dto.getTecnicoId())
                .orElse(null);

        if (incidente == null || tecnico == null) {
            return null;
        }

        // Validación clave
        if (!"TECNICO".equalsIgnoreCase(tecnico.getRol())) {
            return null;
        }

        Asignacion asignacion = new Asignacion();
        asignacion.setIncidente(incidente);
        asignacion.setTecnico(tecnico);
        asignacion.setEstado(dto.getEstado());
        asignacion.setFechaAsignacion(LocalDate.now());

        return asignacionRepository.save(asignacion);
    }

    public Asignacion update(Long id, AsignacionDTO dto) {

        Asignacion asignacion = findById(id);
        if (asignacion == null) return null;

        if (dto.getEstado() != null) {
            asignacion.setEstado(dto.getEstado());
        }

        return asignacionRepository.save(asignacion);
    }

    public void delete(Long id) {
        asignacionRepository.deleteById(id);
    }
}
