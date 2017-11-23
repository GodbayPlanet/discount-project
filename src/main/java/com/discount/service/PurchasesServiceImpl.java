package com.discount.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.discount.domain.Purchase;
import com.discount.wrappers.PurchaseWrapper;

@Service
public class PurchasesServiceImpl implements PurchaseService {

	@Value("${discount.purchasesByUserURL}")
	private String purchasesByUserURL;
	
	@Value("${discount.purchasesByProductIdURL}")
	private String purchasesByProductIdURL;
	
	private RestTemplate restTemplate;
	
	@Autowired
	public PurchasesServiceImpl() {
		this.restTemplate = RESTemplate.restTemplate();
	}
	
	/**
	 * Method returns list of purchases by specific user.  
	 */
	@Override
	public List<Purchase> listOfPurchasesByUser(String userName) {
		PurchaseWrapper purchases = restTemplate.getForObject(purchasesByUserURL.replace("{userName}", userName), 
				PurchaseWrapper.class);
		
		return purchases.getPurchases();
	}

	/**
	 * Method returns list of purchases by product id based on given productId.
	 */
	@Override
	public List<Purchase> listOfPurchasesByProductId(int productId) {
		PurchaseWrapper purchasesByProductId = restTemplate.getForObject(purchasesByProductIdURL.replace("{productId}", 
				String.valueOf(productId)), PurchaseWrapper.class);
		
		return purchasesByProductId.getPurchases();
	}

}
