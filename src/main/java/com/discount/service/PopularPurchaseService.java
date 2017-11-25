package com.discount.service;

import java.util.List;

import com.discount.domain.PopularPurchase;

public interface PopularPurchaseService {
	
	public List<PopularPurchase> listOfPopularPurchases(String userName);
}
