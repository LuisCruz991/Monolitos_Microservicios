package com.incidentflow.incidentes.repository;

import com.incidentflow.incidentes.model.Incidente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface IncidenteRepository extends JpaRepository<Incidente, Long> {
    List<Incidente> findByUsuarioId(Long usuarioId);
    List<Incidente> findByEstado(String estado);
    List<Incidente> findByPrioridad(String prioridad);

    @Query("SELECT i FROM Incidente i WHERE i.estado = :estado AND i.prioridad = :prioridad")
    List<Incidente> findByEstadoAndPrioridad(@Param("estado") String estado, @Param("prioridad") String prioridad);

    @Query("SELECT i FROM Incidente i WHERE i.fechaCreacion BETWEEN :inicio AND :fin")
    List<Incidente> findByFechaCreacionBetween(@Param("inicio") LocalDate inicio, @Param("fin") LocalDate fin);

    @Query("SELECT COUNT(i) FROM Incidente i WHERE i.estado = 'ABIERTO'")
    long countAbiertos();
}