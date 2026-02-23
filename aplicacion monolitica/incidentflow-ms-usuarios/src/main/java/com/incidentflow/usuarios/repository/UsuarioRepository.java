package com.incidentflow.usuarios.repository;

import com.incidentflow.usuarios.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    List<Usuario> findByRol(String rol);
    Optional<Usuario> findByEmail(String email);

    @Query("SELECT u FROM Usuario u WHERE u.rol = :rol AND u.fechaRegistro > :fecha")
    List<Usuario> findByRolAndFechaAfter(@Param("rol") String rol, @Param("fecha") LocalDate fecha);
}