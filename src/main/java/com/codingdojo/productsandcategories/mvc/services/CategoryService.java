package com.codingdojo.productsandcategories.mvc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.productsandcategories.mvc.models.Category;
import com.codingdojo.productsandcategories.mvc.models.Product;
import com.codingdojo.productsandcategories.mvc.repositories.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepo;
	
	@Autowired
	private ProductService productServ;
	
	public Category create(Category category) {
		return categoryRepo.save(category);
	}
	
	public Category findOneById(Long id) {
		Optional<Category> optionalCategory = categoryRepo.findById(id);
		if(optionalCategory.isPresent()) {
			return optionalCategory.get();
		}
		return null;
	}
	
	public List<Category> findAll(){
		return categoryRepo.findAll();
	}
	
	public List<Category> findAllByProducts(Product product){
		return categoryRepo.findAllByProducts(product);
	}
	
	public List<Category> findByProductsNotContains(Product product){
		return categoryRepo.findByProductsNotContains(product);
	}
	
	public Category update(Category category) {
		return categoryRepo.save(category);
	}
	
	public Category addProduct(Long productId, Long categoryId) {
		Category category = this.findOneById(categoryId);
		Product product = productServ.findOneById(productId);
		if(category == null || product == null) {
			return null;
		}
		category.getProducts().add(product);
		return categoryRepo.save(category);
	}

}
