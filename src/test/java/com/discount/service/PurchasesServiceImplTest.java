package com.discount.service;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringRunner;

import com.discount.domain.Purchase;

@RunWith(SpringRunner.class)
public class PurchasesServiceImplTest {
	
	private static final int EXPECTED_LIST_SIZE = 3;
	@Mock
	private PurchaseService purchaseService;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testListOfPurchasesByUser() {
		String userName = "Pero";
		List<Purchase> purchasesByUser = new ArrayList<>();
		
		purchasesByUser.add(new Purchase(1, userName, 11, "2017-11-14T18:14:49.460Z"));
		purchasesByUser.add(new Purchase(2, userName, 22, "2017-12-14T18:14:49.460Z"));
		purchasesByUser.add(new Purchase(3, userName, 33, "2017-14-14T18:14:49.460Z"));
		
		when(purchaseService.listOfPurchasesByUser(userName)).thenReturn(purchasesByUser);
		
		List<Purchase> purchases = purchaseService.listOfPurchasesByUser(userName);
		
		assertNotNull(purchases);
		assertEquals(EXPECTED_LIST_SIZE, purchases.size());
	}

	@Test
	public void testListOfPurchasesByProductId() {
		
		int productId = 111;
		
		List<Purchase> purchasesByProductId = new ArrayList<>();
		purchasesByProductId.add(new Purchase(1, "Pero", productId, "2017-11-14T18:14:49.460Z"));
		purchasesByProductId.add(new Purchase(2, "Perica", productId, "2017-12-14T18:14:49.460Z"));
		purchasesByProductId.add(new Purchase(3, "Ljubisa", productId, "2017-14-14T18:14:49.460Z"));
		
		when(purchaseService.listOfPurchasesByProductId(productId)).thenReturn(purchasesByProductId);
		
		List<Purchase> purchases = purchaseService.listOfPurchasesByProductId(productId);
		
		assertNotNull(purchases);
		assertEquals(EXPECTED_LIST_SIZE, purchases.size());
	}

}
