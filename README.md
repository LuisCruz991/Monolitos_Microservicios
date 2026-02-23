# Monolitos_Microservicios
Arquitectura monolitica y de microservicios

🚀 INCIDENTFLOW - Sistema de Gestión de Tickets de Soporte Técnico
https://img.shields.io/badge/Java-21-orange
https://img.shields.io/badge/Spring%2520Boot-3.5.10-brightgreen
https://img.shields.io/badge/PostgreSQL-16-blue
https://img.shields.io/badge/License-MIT-yellow

📋 Tabla de Contenidos
Descripción General

Arquitectura

Tecnologías Utilizadas

Estructura del Proyecto

Requisitos Previos

Configuración de Base de Datos

Instalación y Ejecución

Guía de Uso

API REST Documentation

Contribución

Licencia

🎯 Descripción General
IncidentFlow es un sistema de gestión de tickets de soporte técnico diseñado para empresas que necesitan organizar y dar seguimiento a incidentes reportados por sus empleados. El sistema permite:

👥 Gestionar usuarios (empleados, técnicos, administradores)

📝 Crear y dar seguimiento a incidentes (tickets de soporte)

🔄 Validar usuarios antes de crear incidentes mediante comunicación REST

📊 Visualizar estadísticas en tiempo real

El proyecto está desarrollado en dos versiones para fines educativos:

🏗️ Versión Monolítica: Todo en una sola aplicación

🧩 Versión Microservicios: Dividida en servicios independientes


🛠️ Tecnologías Utilizadas
Java	21	Lenguaje de programación

Spring Boot	3.5.10	Framework principal}

Spring Data JPA	3.5.10	Persistencia de datos

Spring Web	3.5.10	API REST

PostgreSQL	16	Base de datos

Lombok	
Maven	
HTML/CSS/JS	-	Interfaces de usuario


INCIDENTFLOW-PROYECTO/
│
├── 📁 incidentflow-monolito/                 # Versión Monolítica (Puerto 8080)
│   ├── pom.xml
│   └── src/
│       └── main/
│           ├── java/com/incidentflow/
│           │   ├── controller/
│           │   ├── model/
│           │   ├── repository/
│           │   ├── service/
│           │   └── dto/
│           └── resources/
│               ├── application.properties
│               ├── import.sql
│               └── static/
│                   └── app.html
│
├── 📁 incidentflow-ms-usuarios/              # Microservicio Usuarios (8081)
│   ├── pom.xml
│   └── src/
│       └── main/
│           ├── java/com/incidentflow/usuarios/
│           │   ├── UsuariosApplication.java
│           │   ├── controller/
│           │   ├── model/
│           │   ├── repository/
│           │   ├── service/
│           │   ├── dto/
│           │   └── config/
│           └── resources/
│               ├── application.properties
│               └── static/
│                   └── app-usuarios.html
│
└── 📁 incidentflow-ms-incidentes/             # Microservicio Incidentes (8082)
    ├── pom.xml
    └── src/
        └── main/
            ├── java/com/incidentflow/incidentes/
            │   ├── IncidentesApplication.java
            │   ├── controller/
            │   ├── model/
            │   ├── repository/
            │   ├── service/
            │   ├── dto/
            │   └── config/
            └── resources/
                ├── application.properties
                └── static/
                    └── app-incidentes.html

