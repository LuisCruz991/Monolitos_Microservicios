package com.incidentflow.asignaciones.repository;

import com.incidentflow.asignaciones.model.Asignacion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AsignacionRepository extends JpaRepository<Asignacion, Long>{
}