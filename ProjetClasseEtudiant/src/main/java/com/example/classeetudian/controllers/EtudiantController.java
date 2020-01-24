package com.example.classeetudian.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.expression.Lists;

import com.example.classeetudian.entities.Classe;
import com.example.classeetudian.entities.Etudiant;
import com.example.classeetudian.repositories.ClasseRepository;
import com.example.classeetudian.repositories.EtudiantRepository;

@Controller
public class EtudiantController {

	@Autowired
	EtudiantRepository etudiantRepository;

	@Autowired
	ClasseRepository classeRepository;

	@GetMapping(value = { "/", "/all" })
	public String getAllEtudiants(Map<String, List<Etudiant>> model) {
		model.put("etudiants", etudiantRepository.findAll());

		return "show-etudiants";
	}

	@GetMapping("/formEtudiant")
	public String showFormEtudiant(Model model) {
		model.addAttribute("etudiant", new Etudiant());
		model.addAttribute("classes", classeRepository.findAll());

		return "form-etudiant";
	}

	@PostMapping("/insertEtudiant")
	public String insertEtudiant(@ModelAttribute Etudiant etudiant) {
		etudiantRepository.save(etudiant);
		
//		System.out.println(etudiant);

		return "form-etudiant";
	}

}
