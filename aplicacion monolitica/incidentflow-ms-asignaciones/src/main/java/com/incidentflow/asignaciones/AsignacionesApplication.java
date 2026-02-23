package com.incidentflow.asignaciones;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AsignacionesApplication {
    public static void main(String[] args) {
        SpringApplication.run(AsignacionesApplication.class, args);
        System.out.println("==========================================");
        System.out.println("MS-ASIGNACIONES INICIADO");
        System.out.println("Puerto: 8083");
        System.out.println("==========================================");
        System.out.println("APP DISPONIBLE EN:");
        System.out.println("http://localhost:8083/");
        System.out.println("==========================================");
    }
}