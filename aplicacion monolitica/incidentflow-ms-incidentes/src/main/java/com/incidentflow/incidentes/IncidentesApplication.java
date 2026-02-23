package com.incidentflow.incidentes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class IncidentesApplication {
    public static void main(String[] args) {
        SpringApplication.run(IncidentesApplication.class, args);
        System.out.println("==========================================");
        System.out.println("MS-INCIDENTES INICIADO");
        System.out.println("Puerto: 8082");
        System.out.println("==========================================");
        System.out.println("APP DISPONIBLE EN:");
        System.out.println("http://localhost:8082/");
        System.out.println("==========================================");
    }
}