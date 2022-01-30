package com.austin.controlviews.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.austin.controlviews.models.User;
import com.austin.controlviews.services.UserService;
import com.austin.controlviews.validator.UserValidator;


@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
//	USER CONTROLLER:
//	home - LOGIN/REGISTRATION PAGE
	@GetMapping("/")
	public String index(@ModelAttribute("user") User user) {
		return "index.jsp";
	}
	
//	Register - NEW USER
	@PostMapping("/registration")
	public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
		UserValidator.validate(user, result);
		if(result.hasErrors()) {
			return "index.jsp";
		} else {
			User newUser = userService.registeredUser(user);
			session.setAttribute("userId", newUser.getId());
			return "redirect:/ideas";
		}
	}
	
//	Login - RETURNING USER
	@PostMapping("/login")
	public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, HttpSession session, RedirectAttributes redirectAttributes) {
		if(userService.authenticateUser(email, password)) {
			User user = userService.findByEmail(email);
			session.setAttribute("userId", user.getId());
			return "redirect:/ideas";
		} else {
			redirectAttributes.addFlashAttribute("error", "Invalid user/password");
			return "redirect:/";
		}
	}
	
//	logout - INVALIDATE USER
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	