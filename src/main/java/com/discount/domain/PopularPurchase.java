package com.discount.domain;

import java.util.List;

public class PopularPurchase {

	private Product product;
	
	private List<String> usersWhoRecentlyPurchaseProduct;
	
	public PopularPurchase() {}
	
	public PopularPurchase(Product product, List<String> usersWhoRecentlyPurchaseProduct) {
		this.product = product;
		this.usersWhoRecentlyPurchaseProduct = usersWhoRecentlyPurchaseProduct;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public List<String> getUsersWhoRecentlyPurchaseProduct() {
		return usersWhoRecentlyPurchaseProduct;
	}

	public void setUsersWhoRecentlyPurchaseProduct(
			List<String> usersWhoRecentlyPurchaseProduct) {
		this.usersWhoRecentlyPurchaseProduct = usersWhoRecentlyPurchaseProduct;
	}
	
	@Override
	public String toString() {
		return "Pupular Purchases: " + product.toString() + "\n" + usersWhoRecentlyPurchaseProduct.toString();
	}
}
