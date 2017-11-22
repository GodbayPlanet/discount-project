package com.discount.service;

import java.util.List;

import com.discount.domain.Product;

public interface ProductService {
	
	public List<Product> getAllProducts();
	
	public Product getProductById(int id);
}
