package com.discount.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.discount.domain.PopularPurchase;
import com.discount.service.ErrorResponse;
import com.discount.service.PopularPurchaseService;
import com.discount.service.UserService;

@RestController
public class PopularPurchaseController {

	private PopularPurchaseService popularPurchaseService;
	private UserService userService;

	@Autowired
	public PopularPurchaseController(PopularPurchaseService popularPurchaseService, UserService userService) {
		this.popularPurchaseService = popularPurchaseService;
		this.userService = userService;
	}

	@RequestMapping("/api/recent_purchases/{userName:.+}")
	@Cacheable(value = "popularPurchases", key = "#userName")
	public ResponseEntity<?> getListOfPopularPurchases(@PathVariable("userName") String userName) {
		List<PopularPurchase> popularPurchase = popularPurchaseService.listOfPopularPurchases(userName);
		
		if (!userService.isUserExist(userName)) {
			return new ResponseEntity<ErrorResponse>(new ErrorResponse("User with userName " + userName + " not found"), 
					HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<PopularPurchase>>(popularPurchase, HttpStatus.OK);
	}
	
}
