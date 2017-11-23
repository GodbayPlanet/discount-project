package com.discount.service;

import java.util.List;

import com.discount.domain.Purchase;

public interface PurchaseService {
	
	public List<Purchase> listOfPurchasesByUser(String userName);

	public List<Purchase> listOfPurchasesByProductId(int productId);
}
