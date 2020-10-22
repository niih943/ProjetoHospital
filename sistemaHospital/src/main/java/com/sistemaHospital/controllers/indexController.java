package com.sistemaHospital.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class indexController {
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/sobre")
	public String sobre() {
		return "sobre";
	}
	
	@GetMapping("/areaAcesso")
	public String acesso() {
		return "acesso/areaAcesso";
	}
}
