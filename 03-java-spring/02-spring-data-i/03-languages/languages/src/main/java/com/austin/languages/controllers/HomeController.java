package com.austin.languages.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.austin.languages.models.Language;
import com.austin.languages.services.LanguageService;

@Controller
public class HomeController {
	private final LanguageService langService;
	public HomeController(LanguageService service) {
		this.langService = service;
	}

	@GetMapping("/")
	public String index(Model model, @ModelAttribute("language") Language language) {
		model.addAttribute("allLanguages", this.langService.allLanguages());
		return "index.jsp";
	}
	
	@PostMapping("/")
	public String addLanguage(@Valid @ModelAttribute("language") Language language, BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("allLanguages", this.langService.allLanguages());
			return "index.jsp";
		}
		this.langService.createLanguage(language);
		return "redirect:/";
	}
	
	@GetMapping("/languages/{id}")
	public String detailLang(Model model, @PathVariable("id") Long id) {
		model.addAttribute("thisLang", this.langService.findLanguage(id));
		return "details.jsp";
	}
	
	@GetMapping("/languages/edit/{id}")
	public String edit(Model model, @PathVariable("id") Long id) {
		model.addAttribute("language", this.langService.findLanguage(id));
		return "edit.jsp";
	}

	@PutMapping("/languages/edit/{id}")
	public String update(@Valid @ModelAttribute("language") Language lang, BindingResult result, Model model, @PathVariable("id") Long id) {
		if(result.hasErrors()) {
			model.addAttribute("language", this.langService.findLanguage(id));
			return "edit.jsp";
		}
		this.langService.updateLanguage(lang);
		return "redirect:/languages/{id}";
	}
	
	@DeleteMapping("/delete/{id}")
	public String delete(Model model, @PathVariable("id") Long id) {
		this.langService.deleteLanguage(id);
		return "redirect:/";
	}
}