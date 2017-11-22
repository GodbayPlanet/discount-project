package com.discount.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.discount.domain.Purchase;
import com.discount.wrappers.PurchaseByUserWrapper;

@Service
public class PurchasesServiceByUserImpl implements PurchaseService {

	@Value("${discount.purchasesByUserURL}")
	private String purchasesByUserURL;
	
	private RestTemplate restTemplate;
	
	@Autowired
	public PurchasesServiceByUserImpl() {
		this.restTemplate = RESTemplate.restTemplate();
	}
	
	/**
	 * Method returns list of purchases by specific user.  
	 */
	@Override
	public List<Purchase> listOfPurchasesByUser(String userName) {
		PurchaseByUserWrapper purchases = restTemplate.getForObject(purchasesByUserURL.replace("{userName}", userName), PurchaseByUserWrapper.class);
		return purchases.getPurchases();
	}

}
