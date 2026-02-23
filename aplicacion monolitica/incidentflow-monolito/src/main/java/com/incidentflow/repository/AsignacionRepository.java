package com.incidentflow.repository;

import com.incidentflow.model.Asignacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface AsignacionRepository extends JpaRepository<Asignacion, Long> {
    List<Asignacion> findByTecnicoId(Long tecnicoId);
    Optional<Asignacion> findByIncidenteId(Long incidenteId);
    List<Asignacion> findByEstado(String estado);
}