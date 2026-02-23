-- Usuarios
INSERT INTO usuario (id, nombre, email, rol, fecha_registro) VALUES (1, 'Juan Pérez', 'juan@empresa.com', 'TECNICO', '2026-01-15');
INSERT INTO usuario (id, nombre, email, rol, fecha_registro) VALUES (2, 'María García', 'maria@empresa.com', 'USUARIO', '2026-01-16');
INSERT INTO usuario (id, nombre, email, rol, fecha_registro) VALUES (3, 'Carlos López', 'carlos@empresa.com', 'TECNICO', '2026-01-17');
INSERT INTO usuario (id, nombre, email, rol, fecha_registro) VALUES (4, 'Ana Martínez', 'ana@empresa.com', 'ADMIN', '2026-01-18');


-- Incidentes
INSERT INTO incidentes (id, titulo, descripcion, prioridad, estado, fecha_creacion, usuario_id) VALUES (1, 'Computadora no enciende', 'La PC no responde al botón de encendido', 'ALTA', 'ABIERTO', '2026-02-10', 2);

-- Asignaciones
INSERT INTO asignacion (id, incidente_id, tecnico_id, fecha_asignacion, estado) VALUES (1, 1, 1, '2026-01-15', 'ACTIVA');