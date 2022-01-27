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
@RequestMapping("/products")
public class ProductController {
	@Autowired
	private AppService aservice;
	
	@GetMapping("/new")
	public String newProduct(@ModelAttribute("product") Product prod, Model model) {
		List<Product> allProducts = this.aservice.allProducts();
		model.addAttribute("allProducts", allProducts);
		return "newProduct.jsp";
	}
	
	@PostMapping("/new")
	public String productCreated(@Valid @ModelAttribute("product") Product prod, Model model, BindingResult result) {
		if(result.hasErrors()) {
			List<Product> allProducts = this.aservice.allProducts();
			model.addAttribute("allProducts", allProducts);
			return "newProduct.jsp";
			} else {
				this.aservice.createProduct(prod);
				return "redirect:/";
			}
	}
	
	@GetMapping("")
	public String productList(@ModelAttribute("product") Product prod, Model model) {
		List<Product> allProducts = this.aservice.allProducts();
		model.addAttribute("allProducts", allProducts);
		return "products.jsp";
	}
	
	@GetMapping("/{id}")
	public String detailProd(Model model, @PathVariable("id") Long id) {
		Product productToShow = this.aservice.findProduct(id);
		model.addAttribute("notInProd", this.aservice.findCatNotProd(productToShow));
		model.addAttribute("product", productToShow);
		return "productDetail.jsp";
	}
	
	@PostMapping("/{id}")
	public String addCatToProd(@RequestParam("cats") Long id, @PathVariable("id") Long prodId) {
		Product prodForAddingCat = this.aservice.findProduct(prodId);
		Category catToAdd = this.aservice.findCategory(id);
		this.aservice.addCatToProd(prodForAddingCat, catToAdd);
		return "redirect:/products/{id}";
	}
	
	
}
