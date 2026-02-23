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

🏗️ Arquitectura
Versión Microservicios (2 servicios independientes)
text

┌─────────────────┐      ┌─────────────────┐
│                 │      │                 │
│  MS-USUARIOS    │◄────►│  MS-INCIDENTES  │
│  (Puerto 8081)  │ REST │  (Puerto 8082)  │
│                 │      │                 │
└────────┬────────┘      └────────┬────────┘
         │                        │
         ▼                        ▼
┌─────────────────┐      ┌─────────────────┐
│   PostgreSQL    │      │   PostgreSQL    │
│ IncidentFlow_   │      │ IncidentFlow_   │
│   Usuarios      │      │   Incidentes    │
└─────────────────┘      └─────────────────┘



Características de la Arquitectura
✅ Comunicación síncrona via REST (HTTP)

✅ Bases de datos independientes (una por servicio)

✅ Despliegue independiente (cada servicio en su puerto)

✅ Aislamiento de fallos (un servicio puede caer sin afectar al otro parcialmente)

🛠️ Tecnologías Utilizadas
Tecnología	Versión	Uso
Java	21	Lenguaje de programación
Spring Boot	3.5.10	Framework principal
Spring Data JPA	3.5.10	Persistencia de datos
Spring Web	3.5.10	API REST
PostgreSQL	16	Base de datos
Hibernate	6.4	ORM
Lombok	1.18.36	Reducción de código boilerplate
Maven	3.9	Gestor de dependencias
HTML/CSS/JS	-	Interfaces de usuario
