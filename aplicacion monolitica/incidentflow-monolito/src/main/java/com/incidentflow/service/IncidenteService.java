package com.incidentflow.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.incidentflow.dto.IncidenteDTO;
import com.incidentflow.model.Incidente;
import com.incidentflow.model.Usuario;
import com.incidentflow.repository.IncidenteRepository;
import com.incidentflow.repository.UsuarioRepository;

@Service
public class IncidenteService {

    private final IncidenteRepository incidenteRepository;
    private final UsuarioRepository usuarioRepository;

    public IncidenteService(IncidenteRepository incidenteRepository,
                            UsuarioRepository usuarioRepository) {
        this.incidenteRepository = incidenteRepository;
        this.usuarioRepository = usuarioRepository;
    }

    public List<IncidenteDTO> findAll() {
        return incidenteRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .toList();
    }

    public IncidenteDTO findById(Long id) {
        return mapToDTO(findEntityById(id));
    }

    private IncidenteDTO mapToDTO(Incidente incidente) {
        IncidenteDTO dto = new IncidenteDTO();

        dto.setId(incidente.getId());
        dto.setTitulo(incidente.getTitulo());
        dto.setDescripcion(incidente.getDescripcion());
        dto.setPrioridad(incidente.getPrioridad());
        dto.setEstado(incidente.getEstado());
        dto.setFechaCreacion(incidente.getFechaCreacion());

        if (incidente.getUsuario() != null) {
            dto.setUsuarioId(incidente.getUsuario().getId());
            dto.setUsuarioNombre(incidente.getUsuario().getNombre());
        }

        return dto;
    }

    private Incidente findEntityById(Long id) {
        return incidenteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Incidente no encontrado"));
    }

    public List<Incidente> findByUsuarioId(Long usuarioId) {
        return incidenteRepository.findByUsuarioId(usuarioId);
    }

    public List<Incidente> findByEstado(String estado) {
        return incidenteRepository.findByEstadoIgnoreCase(estado);
    }

    public Incidente create(IncidenteDTO dto) {
        Usuario usuario = usuarioRepository.findById(dto.getUsuarioId())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        Incidente incidente = new Incidente();
        incidente.setTitulo(dto.getTitulo());
        incidente.setDescripcion(dto.getDescripcion());
        incidente.setPrioridad(dto.getPrioridad().toUpperCase());
        incidente.setEstado(dto.getEstado().toUpperCase());
        incidente.setFechaCreacion(LocalDate.now());
        incidente.setUsuario(usuario);

        return incidenteRepository.save(incidente);
    }

    public Incidente update(Long id, IncidenteDTO dto) {
        Incidente incidente = findEntityById(id);

        incidente.setTitulo(dto.getTitulo());
        incidente.setDescripcion(dto.getDescripcion());
        incidente.setPrioridad(dto.getPrioridad().toUpperCase());
        incidente.setEstado(dto.getEstado().toUpperCase());

        return incidenteRepository.save(incidente);
    }

    public void delete(Long id) {
        if (!incidenteRepository.existsById(id)) {
            throw new RuntimeException("No existe el incidente con id: " + id);
        }
        incidenteRepository.deleteById(id);
    }
}