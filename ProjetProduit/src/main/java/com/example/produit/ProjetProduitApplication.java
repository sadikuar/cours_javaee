package com.example.produit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.produit.dao.ProduitDAO;

@SpringBootApplication
public class ProjetProduitApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetProduitApplication.class, args);
	}
	
	@Bean
	public ProduitDAO produitDAO() {
		return new ProduitDAO();
	}

}
