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
public class ProductController {
	
	@Autowired
	private ProductService productServ;
	
	@Autowired
	private CategoryService categoryServ;
	
	@RequestMapping("/")
	public String index(@ModelAttribute("product") Product product, Model model) {
		List<Product> productList = productServ.findAll();
		model.addAttribute("productList",productList);
		return "index.jsp";
	}
	
	@PostMapping("/product/create")
	public String createProduct(@Valid @ModelAttribute("product") Product product, BindingResult result, Model model) {
		if(result.hasErrors()) {
			List<Product> productList = productServ.findAll();
			model.addAttribute("productList",productList);
			return "index.jsp";
		}
		productServ.create(product);
		return "redirect:/";
	}
	
	@RequestMapping("/view/product/{id}")
	public String viewProduct(@PathVariable("id") Long id, Model model) {
		Product product = productServ.findOneById(id);
		
		if(product == null) {
			return "redirect:/";
		}
		List<Category> addCategoryList = categoryServ.findByProductsNotContains(product);
		model.addAttribute("addCategoryList", addCategoryList);
		model.addAttribute("product", product);
		return "displayproduct.jsp";
	}
	
	@RequestMapping("/product/addCategory/{productId}/{categoryId}")
	public String addProduct(@PathVariable("productId") Long productId, @PathVariable("categoryId") Long categoryId) {
		categoryServ.addProduct(productId, categoryId);
		return "redirect:/view/product/" + productId;
	}
	
	
	
}
