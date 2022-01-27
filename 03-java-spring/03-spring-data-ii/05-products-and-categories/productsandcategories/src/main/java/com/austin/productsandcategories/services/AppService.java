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
	
//	Many-To-Many SERVICE:
	
//	products:
	
//	find a product within a specific category:
	public List<Product> findProdNotCat(Category cat) {
		return this.proRepo.findByCategoriesNotContains(cat);
	}
	
//	add product to category
	public void addProdToCat(Product prod, Category cat) {
		List<Product> existingProds = cat.getProducts();
		existingProds.add(prod);
		this.catRepo.save(cat);
	}
	
//	categories:
	
//	find a category within a specific product:
	public List<Category> findCatNotProd(Product prod) {
		return this.catRepo.findByProductsNotContains(prod);
	}
	
//	add category to product
	public void addCatToProd(Product prod, Category cat) {
		List<Category> existingCats = prod.getCategories();
		existingCats.add(cat);
		this.proRepo.save(prod);
	}
	
	
}
