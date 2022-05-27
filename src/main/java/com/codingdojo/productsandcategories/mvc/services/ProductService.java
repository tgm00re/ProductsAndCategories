package com.codingdojo.productsandcategories.mvc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.productsandcategories.mvc.models.Category;
import com.codingdojo.productsandcategories.mvc.models.Product;
import com.codingdojo.productsandcategories.mvc.repositories.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepo;
	
	
	public Product create(Product product) {
		return productRepo.save(product);
	}
	
	public Product findOneById(Long id) {
		Optional<Product> optionalProduct = productRepo.findById(id);
		if(optionalProduct.isPresent()) {
			return optionalProduct.get();
		}
		return null;
	}
	
	public List<Product> findAll(){
		return productRepo.findAll();
	}
	
	public List<Product> findAllByCategories(Category category){
		return productRepo.findAllByCategories(category);
	}
	
	public List<Product> findByCategoriesNotContains(Category category){
		return productRepo.findByCategoriesNotContains(category);
	}
	
	public Product update(Product product) {
		return productRepo.save(product);
	}
	
	
}
