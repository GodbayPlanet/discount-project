package com.discount.controllers;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.discount.domain.Purchase;
import com.discount.service.PurchaseService;

@RestController
public class PurchaseController {

	private static final int FROM_INDEX = 0;
	private PurchaseService purchaseService;
	
	@Autowired
	public PurchaseController(PurchaseService purchaseService) {
		this.purchaseService = purchaseService;
	}
	
	/**
	 * Method use PurchaseService to return list of purchases by specific user based on given userName.
	 * 
	 * @param userName
	 * @return
	 */
	@RequestMapping("/api/purchases/by_user/{userName}")
	public List<Purchase> getListOfPurchasesByUser(@PathVariable("userName") String userName, 
			@RequestParam(value = "limit", required = false) Integer limit) {
		
		List<Purchase> listOfPurchasesByUser = purchaseService.listOfPurchasesByUser(userName);
		
		if (limit == null) {
			return listOfPurchasesByUser;
		} else {
			return listOfPurchasesByUser.stream().collect(Collectors.toList()).subList(FROM_INDEX, limit);
		}
	}
	
}
