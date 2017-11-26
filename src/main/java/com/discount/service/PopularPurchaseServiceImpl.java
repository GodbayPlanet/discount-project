package com.discount.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.discount.domain.PopularPurchase;
import com.discount.domain.Purchase;
import com.discount.wrappers.ProductByProductIdWrapper;

@Service
public class PopularPurchaseServiceImpl implements PopularPurchaseService {

	private PurchaseService purchaseService;
	private ProductService productService;
	
	@Autowired
	public PopularPurchaseServiceImpl(PurchaseService purchaseService, ProductService productService) {
		this.purchaseService = purchaseService;
		this.productService = productService;
	}
	
	/**
	 * Method returns list of Popular purchases based on given userName. First we getting list of purchases by user name.
	 * Then with method getPurchasesByProductId() we get list of all purchases by productId and in the end with method
	 * getPopularPurchases() method we iterate through each list of purchases by productId and for each product we add all users
	 * who recently bought product.
	 */
	@Override
	public List<PopularPurchase> listOfPopularPurchases(String userName) {
		
		List<PopularPurchase> popularPurchases = new ArrayList<>();
		
		List<Purchase> purchasesByUser = purchaseService.listOfPurchasesByUser(userName);
		
		List<List<Purchase>> listOfAllPurchasesByProductId = new ArrayList<>();
		
		getPurchasesByProductId(purchasesByUser, listOfAllPurchasesByProductId);
		
		//Sorting list so the list of purchases by productId with most purchases is first.
		listOfAllPurchasesByProductId.sort((purchasesByProductId1, purchasesByProductId2) -> 
			(purchasesByProductId2.size() - purchasesByProductId1.size()));
		
		getPopularPurchases(userName, popularPurchases, listOfAllPurchasesByProductId);
		
		return popularPurchases;
	}

	/**
	 * Method fills list of popular purchases with purchases. Also it does not fill list of users who
	 * recently purchase product with duplicate users.
	 * @param userName
	 * @param popularPurchases
	 * @param listOfAllPurchasesByProductId
	 */
	private void getPopularPurchases(String userName, List<PopularPurchase> popularPurchases, 
			List<List<Purchase>> listOfAllPurchasesByProductId) {
		
		listOfAllPurchasesByProductId.forEach(listOfPurchases -> {
			ProductByProductIdWrapper product = productService.getProductById(listOfPurchases.get(0).getProductId());
			
			List<String> usersWhoPurchaseProduct = new ArrayList<>();
			
			listOfPurchases.forEach(purchase -> {
				if (!(purchase.getUsername().equals(userName)))
					usersWhoPurchaseProduct.add(purchase.getUsername());
			});
			
			popularPurchases.add(new PopularPurchase(product.getProduct(), 
					usersWhoPurchaseProduct.stream().distinct().collect(Collectors.toList())));
		});
	}

	/**
	 * Method fills the list of all Purchases by ProductId with purchases.
	 * @param purchasesByUser
	 * @param listOfAllPurchasesByProductId
	 */
	private void getPurchasesByProductId(List<Purchase> purchasesByUser, List<List<Purchase>> listOfAllPurchasesByProductId) {
		purchasesByUser.forEach(purchaseByUser -> {
			List<Purchase> purchasesByProductId = purchaseService.listOfPurchasesByProductId(purchaseByUser.getProductId());
			
			listOfAllPurchasesByProductId.add(purchasesByProductId);
		});
	}

}
