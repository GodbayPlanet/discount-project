package com.discount.service;

import java.util.List;

import com.discount.domain.Product;
import com.discount.wrappers.ProductByProductIdWrapper;

public interface ProductService {
	
	public List<Product> getAllProducts();
	
	public ProductByProductIdWrapper getProductById(int id);
	
	public boolean isProductExist(int productId);
}
