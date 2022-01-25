package com.austin.dojosNinjas.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.austin.dojosNinjas.models.Dojo;
import com.austin.dojosNinjas.services.AppService;

@Controller
@RequestMapping("/dojos")
public class DojoController {
	@Autowired
	private AppService aservice;
	
	@GetMapping("/new")
	public String newDojo(@ModelAttribute("dojo") Dojo dojo) {
		return "dojo.jsp";
	}
	
	@PostMapping("/new")
	public String dojoNew(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
		if(result.hasErrors()) {
			return "dojo.jsp";
		} else {
		this.aservice.createDojo(dojo);
		return "redirect:/ninjas/new";
		}
	}
	
	@GetMapping("/{id}")
	public String oneDojo(Model model, @PathVariable("id") Long id) {
		model.addAttribute("dojo", this.aservice.findOneDojo(id));
		return "location.jsp";
	}
}
