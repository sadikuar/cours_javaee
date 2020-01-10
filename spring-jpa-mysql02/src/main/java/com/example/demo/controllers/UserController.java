package com.example.demo.controllers;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
	@GetMapping(value = { "/", "/all" })
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

	@RequestMapping(value = "search", method = RequestMethod.GET)
	public String showPerson(@RequestParam String personId, Model model) {
//		System.out.println(personId);
		List<Person> listPerson = userRepository.findAll();

		Optional<Person> optional = listPerson.stream().filter(p -> p.getId() == Integer.parseInt(personId))
				.findFirst();

		if (optional.isPresent()) {
			model.addAttribute("person", optional.get());
			try {
				model.addAttribute("age", userService
						.calculateAge(new SimpleDateFormat("dd.MM.yyyy").parse(optional.get().getBirthDate())));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}

		return "person-search";
	}
}
