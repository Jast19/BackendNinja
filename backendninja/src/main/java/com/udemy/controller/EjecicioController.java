package com.udemy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ejercicio")
public class EjecicioController {
	
	public static final String PASO1 = "ejercicio1";
	public static final String PASO2 = "ejecicio2";
	
	@GetMapping("/paso1")
	public String showEjercicio() {
		return PASO1;
	}

}
