package com.codingdojo.productsandcategories.mvc.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.productsandcategories.mvc.models.Category;
import com.codingdojo.productsandcategories.mvc.models.Product;
import com.codingdojo.productsandcategories.mvc.services.CategoryService;
import com.codingdojo.productsandcategories.mvc.services.ProductService;

@Controller
public class CategoryController {
	
	@Autowired
	private CategoryService categoryServ;
	
	@Autowired
	private ProductService productServ;

	@RequestMapping("/category")
	public String categoryIndex(@ModelAttribute("category") Category category, Model model) {
		List<Category> categoryList = categoryServ.findAll();
		model.addAttribute("categoryList", categoryList);
		return "category.jsp";
	}
	
	@PostMapping("/category/create")
	public String createCategory(@Valid @ModelAttribute("category") Category category, BindingResult result, Model model) {
		if(result.hasErrors()) {
			List<Category> categoryList = categoryServ.findAll();
			model.addAttribute("categoryList", categoryList);
			return "category.jsp";
		}
		categoryServ.create(category);
		return "redirect:/category";
	}
	
	
	@RequestMapping("/view/category/{id}")
	public String displayCategory(Model model, @PathVariable("id") Long id) {
		Category category = categoryServ.findOneById(id);
		if(category == null) {
			return "redirect:/category";
		}
		List<Product> addProductList = productServ.findByCategoriesNotContains(category);
		model.addAttribute("category", category);
		model.addAttribute("addProductList",addProductList);
		return "displaycategory.jsp";
	}
	
	@RequestMapping("/category/addproduct/{productId}/{categoryId}")
	public String addProduct(@PathVariable("productId") Long productId, @PathVariable("categoryId") Long categoryId) {
		categoryServ.addProduct(productId, categoryId);
		return "redirect:/view/category/" + categoryId;
	}
	
}
