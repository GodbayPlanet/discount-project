package com.discount.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.discount.domain.Product;
import com.discount.wrappers.ProductByProductIdWrapper;
import com.discount.wrappers.ProductWrapper;

@Service
public class ProductServiceImpl implements ProductService {

	private RestTemplate restTemplate;
	
	@Value("${discount.productsURL}")
	private String productsURL;
	
	@Value("${discount.productByProductIdURL}")
	private String productByProductId;
	
	@Autowired
	public ProductServiceImpl() {
		this.restTemplate = RESTemplate.restTemplate();
	}

	/**
	 * Method returns list of products from server.
	 */
	@Override
	public List<Product> getAllProducts() {
		ProductWrapper productWrapper = restTemplate.getForObject(productsURL, ProductWrapper.class);
		return productWrapper.getProducts();
	}

	@Override
	public ProductByProductIdWrapper getProductById(int id) {
		return restTemplate.getForObject(productByProductId.replace("{productId}", String.valueOf(id)), ProductByProductIdWrapper.class);
	}

}
