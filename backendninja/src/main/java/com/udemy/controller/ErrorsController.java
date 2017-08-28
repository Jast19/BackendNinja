package com.udemy.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorsController {
	
	private static final String ERROR_500 = "error/500";
	
	@ExceptionHandler(Exception.class)
	public String showInternalServerError() {
		return ERROR_500;
	}
	
}
