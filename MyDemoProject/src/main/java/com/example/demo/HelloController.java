package com.example.demo;

import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {

	@RequestMapping("/hello")
	public String sayHello(@RequestParam(name = "name", required = false, defaultValue = "Toto") String name,
			Model model) {
		String[] names = new String[] { "John", "Marvel", "Kevin", "Maverick", "Ellena" };
		
		model.addAttribute("name", names[new Random().nextInt(names.length)]);
//		model.addAttribute("names", names);

		return "hello";
	}

}
