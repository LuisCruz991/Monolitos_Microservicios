package com.incidentflow.usuarios;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class IncidentflowMsUsuariosApplication {
	public static void main(String[] args) {
		SpringApplication.run(IncidentflowMsUsuariosApplication.class, args);
		System.out.println("==========================================");
		System.out.println("✅ MS-USUARIOS INICIADO CORRECTAMENTE");
		System.out.println("🔗 Puerto: 8081");
		System.out.println("🔗 Base de datos: PostgreSQL - IncidentFlow_Usuarios");
		System.out.println("🔗 API REST: http://localhost:8081/api/usuarios");
		System.out.println("🔗 App Web: http://localhost:8081/app-usuarios.html");
		System.out.println("==========================================");
	}
}