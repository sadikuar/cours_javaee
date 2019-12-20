package com.example.produit.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.produit.dao.ProduitDAO;
import com.example.produit.model.Produit;

@Controller
public class ProduitsController {

	@Autowired
	ProduitDAO dao;

	@GetMapping("/produits")
	public String produits(Map<String, Object> model) {
		model.put("produits", dao.getAllProduits());
		return "produits";
	}

	@GetMapping("/formulaire")
	public String formulaire() {
		return "formulaire";
	}

	@PostMapping("/produit")
	public String saveProduit(@Valid @ModelAttribute Produit produit, BindingResult errors, Model model) {
		return "redirect:produits";
	}
}
