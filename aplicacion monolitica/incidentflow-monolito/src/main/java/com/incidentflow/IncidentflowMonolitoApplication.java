package com.incidentflow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class IncidentflowMonolitoApplication {
    public static void main(String[] args) {
        SpringApplication.run(IncidentflowMonolitoApplication.class, args);
        System.out.println("==========================================");
        System.out.println("INCIDENTFLOW MONOLITO INICIADO");
        System.out.println("Puerto: 8080");
        System.out.println("==========================================");
        System.out.println("APP DISPONIBLE EN:");
        System.out.println("http://localhost:8080/");
        System.out.println("==========================================");
    }
}