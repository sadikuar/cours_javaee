package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.data.EtudiantsDAO;

@SpringBootApplication
public class ProjetEtudiantApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetEtudiantApplication.class, args);
	}

	@Bean
	public EtudiantsDAO etudiantsDAO() {
		return new EtudiantsDAO();
	}

}
