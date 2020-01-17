package com.example.classeetudian.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.classeetudian.entities.Classe;
import com.example.classeetudian.repositories.ClasseRepository;

@Controller
public class ClasseController {

	@Autowired
	ClasseRepository classeRepository;

	@GetMapping("/formClasse")
	public String showFormClasse(Model model) {
		model.addAttribute("classe", new Classe());

		return "form-classe";
	}

	@PostMapping("/insertClasse")
	public String insertClasse(@ModelAttribute Classe classe) {
		classeRepository.save(classe);

		return "form-classe";
	}

}
