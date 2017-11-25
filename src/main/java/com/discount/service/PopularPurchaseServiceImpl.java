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
	 * This method is long, it can be much better....
	 */
	@Override
	public List<PopularPurchase> listOfPopularPurchases(String userName) {
		
		List<PopularPurchase> popularPurchases = new ArrayList<>();
		
		List<Purchase> purchasesByUser = purchaseService.listOfPurchasesByUser(userName);
		
		List<List<Purchase>> listOfAllPurchasesByProductId = new ArrayList<>();
		
		purchasesByUser.forEach(purchaseByUser -> {
			List<Purchase> purchasesByProductId = purchaseService.listOfPurchasesByProductId(purchaseByUser.getProductId());
			
			listOfAllPurchasesByProductId.add(purchasesByProductId);
		});
		
		//Sorting list so the list of purchases by productId with most purchases is first.
		listOfAllPurchasesByProductId.sort((purchasesByProductId1, purchasesByProductId2) -> 
			(purchasesByProductId2.size() - purchasesByProductId1.size()));
		
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
		
		return popularPurchases;
	}

}
