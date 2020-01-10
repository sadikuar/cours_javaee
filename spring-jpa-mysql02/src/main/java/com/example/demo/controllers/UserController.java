package com.example.demo.controllers;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entities.Person;
import com.example.demo.repository.UserRepository;
import com.example.demo.services.UserService;

@Controller
public class UserController {

	@Autowired
	UserRepository userRepository;

	@Autowired
	UserService userService;

	@Autowired
	@GetMapping(value = {"/", "/all"})
	public String getAll(Map<String, Object> model) {
		model.put("persons", userRepository.findAll());

		return "list";
	}

	@GetMapping("/form")
	public String personForm(Model model) {
		model.addAttribute("person", new Person());

		return "person-form";
	}

	@PostMapping("/insert")
	public String insertPerson(@ModelAttribute Person person, Model model) {
		userRepository.save(person);

		return "person-form";
	}

	@GetMapping("/search")
	public String showPersonSearch(Model model) {
		model.addAttribute("person", new Person());
		model.addAttribute("persons", userRepository.findAll());

		return "person-search";
	}
}
