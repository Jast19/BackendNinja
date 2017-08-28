package com.udemy.controller;
//enviar informacion a una vista
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.udemy.component.ExampleComponent;
import com.udemy.model.Person;
import com.udemy.service.imp.ExampleServiceImpl;


@Controller
@RequestMapping("/example")
public class ExampleController {
	
	@Autowired
	@Qualifier("exampleService")
	private ExampleServiceImpl exampleServiceImpl;  
	
	@Autowired
	@Qualifier("exampleComponent")
	private ExampleComponent exampleComponent;
	
	//primera forma
	@GetMapping("/exampleString")
	public String example(Model model) {
		exampleComponent.sayHello();
		model.addAttribute("persona", exampleServiceImpl.getListPeople());
		return "example";
	}
	
	//segunda forma
	@GetMapping("/exampleMAV")
	public ModelAndView exampleMAV() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("persona", exampleServiceImpl.getListPeople());
		mv.setViewName("example");
		return mv;
	}

}
