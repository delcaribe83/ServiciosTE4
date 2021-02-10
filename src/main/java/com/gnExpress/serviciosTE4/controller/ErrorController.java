package com.gnExpress.serviciosTE4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/error")
public class ErrorController {
	
	
	@GetMapping("/indexError")
	public String error() {
		
		
		return "error";
	}

}
