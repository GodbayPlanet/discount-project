package com.discount.wrappers;

import java.util.List;

import com.discount.domain.Purchase;

public class PurchaseByUserWrapper {

	private List<Purchase> purchases;

	public List<Purchase> getPurchases() {
		return purchases;
	}

	public void setPurchases(List<Purchase> purchases) {
		this.purchases = purchases;
	}
}
