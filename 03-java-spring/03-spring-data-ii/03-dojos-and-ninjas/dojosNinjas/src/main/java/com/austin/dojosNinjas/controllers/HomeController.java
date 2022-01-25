package com.austin.dojosNinjas.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
//import com.austin.dojosNinjas.services.AppService;

@Controller
public class HomeController {
//	private final AppService aService;
//	public HomeController(AppService service) {
//		this.aService = service;
//	}
	
	@GetMapping("/")
	public String index() {
		return "index.jsp";
	}
	
}
