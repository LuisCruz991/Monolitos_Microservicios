# Monolitos_Microservicios
Arquitectura monolitica y de microservicios

# INCIDENTFLOW - SISTEMA DE TICKETS DE SOPORTE TÉCNICO
# INCIDENTFLOW
Sistema de gestión de tickets de soporte técnico desarrollado con Spring Boot y PostgreSQL.

# DESCRIPCIÓN
IncidentFlow permite a empresas gestionar incidentes reportados por empleados. Los usuarios pueden crear tickets y los técnicos resolverlos de manera organizada.

# ARQUITECTURA
El proyecto tiene DOS versiones:

VERSIÓN MONOLÍTICA (Todo junto)

Puerto: 8080

Una sola base de datos

Una sola aplicación

# VERSIÓN MICROSERVICIOS (Separado)

MS-Usuarios (Puerto 8081): Gestiona empleados

MS-Incidentes (Puerto 8082): Gestiona tickets

Se comunican por REST

# TECNOLOGÍAS
Java 21

Spring Boot 3.5.10

Spring Data JPA

Spring Web

PostgreSQL 18

Lombok

Maven

HTML/CSS/JavaScript

# REQUISITOS PREVIOS
Java JDK 21

Maven 3.9+

PostgreSQL 16

Git (opcional)

# CONFIGURACIÓN DE BASE DE DATOS
Crear las bases de datos en PostgreSQL:
CREATE DATABASE "IncidentFlow_Usuarios";
CREATE DATABASE "IncidentFlow_Incidentes";

Credenciales por defecto:
Usuario: postgres
Password: 1234

Si usas otras credenciales, actualiza los archivos application.properties.

# ACCESO A LAS APLICACIONES
Microservicio Usuarios
App Web: http://localhost:8081/app-usuarios.html
API REST: http://localhost:8081/api/usuarios

# Microservicio Incidentes
App Web: http://localhost:8082/app-incidentes.html
API REST: http://localhost:8082/api/incidentes

# Versión Monolítica
App Web: http://localhost:8080/app.html
API Usuarios: http://localhost:8080/api/usuarios
API Incidentes: http://localhost:8080/api/incidentes

# FUNCIONALIDADES
MS-Usuarios
Ver listado de usuarios
Crear nuevo usuario
Editar usuario
Eliminar usuario
Estadísticas por rol

# MS-Incidentes
Ver listado de incidentes
Crear incidente (valida usuario en MS-Usuarios)
Cambiar estado (Abierto, Proceso, Cerrado)
Filtrar por estado y prioridad
Eliminar incidente

