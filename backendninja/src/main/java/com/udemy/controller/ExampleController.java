package com.udemy.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.udemy.model.Person;


@Controller
@RequestMapping("/example")
public class ExampleController {
	
	//primera forma
	@GetMapping("/exampleString")
	public String example(Model model) {
		model.addAttribute("persona", getPeople());
		return "example";
	}
	
	//segunda forma
	@GetMapping("/exampleMAV")
	public ModelAndView exampleMAV() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("persona", getPeople());
		mv.setViewName("example");
		return mv;
	}

	private List<Person> getPeople(){
		List<Person> persona = new ArrayList<>();
		persona.add(new Person("jon", 23));
		persona.add(new Person("ata", 2));
		persona.add(new Person("toto", 93));
		persona.add(new Person("lalo", 43));
		
		return persona;
	}
}
