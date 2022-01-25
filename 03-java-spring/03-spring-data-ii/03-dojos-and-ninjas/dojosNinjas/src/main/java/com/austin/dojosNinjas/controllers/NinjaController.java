package com.austin.dojosNinjas.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.austin.dojosNinjas.models.Dojo;
import com.austin.dojosNinjas.models.Ninja;
import com.austin.dojosNinjas.services.AppService;

@Controller
@RequestMapping("/ninjas")
public class NinjaController {
	@Autowired
	private AppService aservice;
	
	@GetMapping("/new")
	public String newNinja(@ModelAttribute("ninja") Ninja ninja, Model model) {
		List<Dojo> allDojos = this.aservice.allDojos();
		model.addAttribute("allDojos", allDojos);
		return "ninja.jsp";
	}
	
	@PostMapping("/new")
	public String ninjaNew(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result, Model model) {
		if(result.hasErrors()) {
			List<Dojo> allDojos = this.aservice.allDojos();
			model.addAttribute("allDojos", allDojos);
			return "ninja.jsp";
		} else {
			this.aservice.createNinja(ninja);
			return "redirect:/dojos/" + ninja.getDojo().getId();
		}
	}
}
