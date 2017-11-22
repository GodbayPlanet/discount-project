package com.discount.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.discount.domain.Purchase;
import com.discount.service.PurchaseService;

@RestController
public class PurchaseController {

	private PurchaseService purchaseService;
	
	@Autowired
	public PurchaseController(PurchaseService purchaseService) {
		this.purchaseService = purchaseService;
	}
	
	/**
	 * Method use PurchaseService to return list of purchases by specific user based on given userName.
	 * @param userName
	 * @return
	 */
	@RequestMapping("/api/purchases/by_user/{userName}")
	public List<Purchase> getListOfPurchasesByUser(@PathVariable("userName") String userName) {
		return purchaseService.listOfPurchasesByUser(userName);
	}
	
}
