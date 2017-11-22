package com.discount.wrappers;

import java.util.List;

import com.discount.domain.Product;

public class ProductWrapper {

	private List<Product> products;

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
}
