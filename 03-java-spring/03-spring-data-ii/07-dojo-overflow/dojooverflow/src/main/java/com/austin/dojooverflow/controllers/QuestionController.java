package com.austin.dojooverflow.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.austin.dojooverflow.models.Answer;
import com.austin.dojooverflow.models.NewQuestion;
import com.austin.dojooverflow.services.AppService;

@Controller
public class QuestionController {
	@Autowired
	private AppService aservice;
	
//	root route redirects to questions route
	@GetMapping("/")
	public String index() {
		return "redirect:/questions";
	}
	
//	questions route displays dashboard
	@GetMapping("/questions")
	public String dashboard(Model model) {
		model.addAttribute("questions", this.aservice.allQuestions());
		return "dashboard.jsp";
	}
	
//	new question link routes to new question page.
	@GetMapping("/questions/new")
	public String newQuestion(@ModelAttribute("newQuestion") NewQuestion newQuestion) {
		return "newQuestion.jsp";
	}
	
//	creating new question
	@PostMapping("/questions/new")
	public String CreateQuestion(@Valid @ModelAttribute("newQuestion") NewQuestion newQuestion, BindingResult result) {
		if(result.hasErrors()) {
			return "newQuestion.jsp";
		} else {
			this.aservice.createQuestion(newQuestion);
			return "redirect:/questions";
		}
	}
	
	
//	question id page to input answer
	@GetMapping("/questions/{id}")
	public String questionProfile(@PathVariable("id") Long id, @ModelAttribute("answer") Answer answer, Model model) {
		model.addAttribute("question", this.aservice.findQuestion(id));
		return "profile.jsp";
	}
	
	
}
