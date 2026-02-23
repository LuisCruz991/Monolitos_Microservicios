package com.incidentflow.incidentes.service;

import com.incidentflow.incidentes.model.Incidente;
import com.incidentflow.incidentes.repository.IncidenteRepository;
import com.incidentflow.incidentes.dto.IncidenteDTO;
import com.incidentflow.incidentes.dto.UsuarioDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.HttpClientErrorException;
import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
public class IncidenteService {

    @Autowired
    private IncidenteRepository incidenteRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Value("${usuarios.service.url}")
    private String usuariosServiceUrl;

    // COMUNICACIÓN REST CON MS-USUARIOS
    public UsuarioDTO getUsuarioById(Long usuarioId) {
        try {
            String url = usuariosServiceUrl + "/" + usuarioId;
            return restTemplate.getForObject(url, UsuarioDTO.class);
        } catch (HttpClientErrorException.NotFound e) {
            System.out.println("❌ Usuario " + usuarioId + " no encontrado en MS-Usuarios");
            return null;
        } catch (Exception e) {
            System.out.println("❌ Error conectando con MS-Usuarios: " + e.getMessage());
            return null;
        }
    }

    public boolean existeUsuario(Long usuarioId) {
        try {
            String url = usuariosServiceUrl + "/" + usuarioId + "/exists";
            return Boolean.TRUE.equals(restTemplate.getForObject(url, Boolean.class));
        } catch (Exception e) {
            // Fallback: intentar obtener el usuario directamente
            UsuarioDTO usuario = getUsuarioById(usuarioId);
            return usuario != null;
        }
    }

    public List<Incidente> findAll() {
        return incidenteRepository.findAll();
    }

    public Incidente findById(Long id) {
        return incidenteRepository.findById(id).orElse(null);
    }

    public List<Incidente> findByUsuarioId(Long usuarioId) {
        return incidenteRepository.findByUsuarioId(usuarioId);
    }

    public List<Incidente> findByEstado(String estado) {
        return incidenteRepository.findByEstado(estado);
    }

    // CREAR INCIDENTE CON VALIDACIÓN EN MS-USUARIOS
    public Incidente create(IncidenteDTO dto) {
        // 1. Verificar que el usuario existe en MS-Usuarios
        UsuarioDTO usuario = getUsuarioById(dto.getUsuarioId());
        if (usuario == null) {
            throw new RuntimeException("El usuario con ID " + dto.getUsuarioId() + " no existe en el sistema");
        }

        // 2. Crear el incidente
        Incidente incidente = new Incidente();
        incidente.setTitulo(dto.getTitulo());
        incidente.setDescripcion(dto.getDescripcion());
        incidente.setPrioridad(dto.getPrioridad());
        incidente.setEstado(dto.getEstado() != null ? dto.getEstado() : "ABIERTO");
        incidente.setFechaCreacion(LocalDate.now());
        incidente.setUsuarioId(dto.getUsuarioId());
        incidente.setNombreUsuario(usuario.getNombre()); // Guardamos cache del nombre

        System.out.println("✅ Incidente creado para usuario: " + usuario.getNombre() + " (" + usuario.getEmail() + ")");
        return incidenteRepository.save(incidente);
    }

    public Incidente update(Long id, IncidenteDTO dto) {
        Incidente incidente = findById(id);
        if (incidente != null) {
            incidente.setTitulo(dto.getTitulo());
            incidente.setDescripcion(dto.getDescripcion());
            incidente.setPrioridad(dto.getPrioridad());
            incidente.setEstado(dto.getEstado());
            return incidenteRepository.save(incidente);
        }
        return null;
    }

    public void delete(Long id) {
        incidenteRepository.deleteById(id);
    }

    // Métodos adicionales con estadísticas
    public long countIncidentesAbiertos() {
        return incidenteRepository.countAbiertos();
    }

    public List<Incidente> getIncidentesPorRangoFechas(LocalDate inicio, LocalDate fin) {
        return incidenteRepository.findByFechaCreacionBetween(inicio, fin);
    }
}