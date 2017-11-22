package com.discount.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.discount.domain.Product;

@Service
public class ProductServiceImpl implements ProductService {

	@Value("${discount.productsURL}")
	private String productsURL;
	
	@Override
	public List<Product> getAllProducts() {
		
		return null;
	}

	@Override
	public Product getProductById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
