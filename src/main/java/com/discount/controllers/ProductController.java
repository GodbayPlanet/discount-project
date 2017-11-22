package com.discount.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.discount.domain.Product;
import com.discount.service.ProductService;
import com.discount.wrappers.ProductByProductIdWrapper;

@RestController
public class ProductController {

	private ProductService productService;

	@Autowired
	public ProductController(ProductService productService) {
		this.productService = productService;
	}
	
	/**
	 * Method uses ProductService interface to return list of products.
	 * @return
	 */
	@RequestMapping("/api/products")
	public List<Product> getProducts() {
		return productService.getAllProducts();
	}
	
	/**
	 * Method returns ProductByProductIdWrapper object based on given productId.
	 * @param id
	 * @return
	 */
	@RequestMapping("/api/products/{productId}") 
	public ProductByProductIdWrapper getProduct(@PathVariable("productId") int id) {
		return productService.getProductById(id);
	}
}
