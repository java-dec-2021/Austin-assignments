package com.austin.productsandcategories.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.austin.productsandcategories.models.Category;
import com.austin.productsandcategories.models.Product;
import com.austin.productsandcategories.repositories.CategoryRepository;
import com.austin.productsandcategories.repositories.ProductRepository;

@Service
public class AppService {
	@Autowired
	private CategoryRepository catRepo;
	@Autowired
	private ProductRepository proRepo;
	
//	Category Service:
	
//	find all categories:
	public List<Category> allCategories() {
		return this.catRepo.findAll();
	}
	
//	create category:
	public Category createCategory(Category cat) {
		return this.catRepo.save(cat);
	}
	
//	find one category:
	public Category findCategory(Long id) {
		return this.catRepo.findById(id).orElse(null);
	}
	
//	Product Service:
	
//	find all products:
	public List<Product> allProducts() {
		return this.proRepo.findAll();
	}
	
//	create a product:
	public Product createProduct(Product prod) {
		return this.proRepo.save(prod);
	}
	
//	find one product:
	public Product findProduct(Long id) {
		return this.proRepo.findById(id).orElse(null);
	}
	
//	CONNECTION SERVICE:
	
//	find a product within a specific category:
	
	
//	find a category within a specific product:
	
	
	
}
