package com.incidentflow.incidentes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class IncidentflowMsincidentesApplication {
    public static void main(String[] args) {
        SpringApplication.run(IncidentflowMsincidentesApplication.class, args);
        System.out.println("==========================================");
        System.out.println("✅ MS-INCIDENTES INICIADO CORRECTAMENTE");
        System.out.println("🔗 Puerto: 8082");
        System.out.println("🔗 Base de datos: PostgreSQL - IncidentFlow_Incidentes");
        System.out.println("🔗 API REST: http://localhost:8082/api/incidentes");
        System.out.println("🔗 App Web: http://localhost:8082/app-incidentes.html");
        System.out.println("🔗 Conectado a MS-Usuarios: http://localhost:8081");
        System.out.println("==========================================");
    }
}