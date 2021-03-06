package com.austin.productsandcategories.controllers;

import java.util.List;

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
import org.springframework.web.bind.annotation.RequestParam;

import com.austin.productsandcategories.models.Category;
import com.austin.productsandcategories.models.Product;
import com.austin.productsandcategories.services.AppService;

@Controller
@RequestMapping("/categories")
public class CategoryController {
	@Autowired
	private AppService aservice;
	
	@GetMapping("/new")
	public String newCategory(@ModelAttribute("category") Category cat) {
		return "newCategory.jsp";
	}

	@PostMapping("/new")
	public String categoryCreated(@Valid @ModelAttribute("category") Category cat, BindingResult result) {
		if(result.hasErrors()) {
			return "newCategory.jsp";
		} else {
			this.aservice.createCategory(cat);
			return "redirect:/";
		}
	}
	
	@GetMapping("")
	public String categoryList(@ModelAttribute("category") Category cat, Model model) {
		List<Category> allCategories = this.aservice.allCategories();
		model.addAttribute("allCategories", allCategories);
		return "categories.jsp";
	}
	
	@GetMapping("/{id}")
	public String detailCat(Model model, @PathVariable("id") Long id) {
		Category categoryToShow = this.aservice.findCategory(id);
		model.addAttribute("notInCat", this.aservice.findProdNotCat(categoryToShow));
		model.addAttribute("category", categoryToShow);
		return "categoryDetail.jsp";
	}
	
	@PostMapping("/{id}")
	public String addProdToCat(@RequestParam("prods") Long id, @PathVariable("id") Long catId) {
		Category catForAddingProd = this.aservice.findCategory(catId);
		Product prodToAdd = this.aservice.findProduct(id);
		this.aservice.addProdToCat(prodToAdd, catForAddingProd);
		return "redirect:/categories/{id}";
	}

}
