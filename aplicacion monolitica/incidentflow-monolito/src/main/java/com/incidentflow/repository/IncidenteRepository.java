package com.incidentflow.repository;

import com.incidentflow.model.Incidente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface IncidenteRepository extends JpaRepository<Incidente, Long> {
    List<Incidente> findByEstadoIgnoreCase(String estado);
    List<Incidente> findByPrioridadIgnoreCase(String prioridad);
    List<Incidente> findByUsuarioId(Long usuarioId);

    @Query("""
        SELECT i FROM Incidente i
        WHERE UPPER(i.prioridad) = UPPER(:prioridad)
          AND UPPER(i.estado) = UPPER(:estado)
    """)
    List<Incidente> findByPrioridadAndEstado(
            @Param("prioridad") String prioridad,
            @Param("estado") String estado
    );
}