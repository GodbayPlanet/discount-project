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

//import com.discount.config.Config;
import com.discount.domain.Product;
import com.discount.wrappers.ProductByProductIdWrapper;

@RunWith(SpringRunner.class)
public class ProductServiceImplTest {

	private static final int PRODUCT_SIZE = 5;

	private static final int PRODUCT_PRICE = 56;

	private static final String PRODUCT_FACE = "||";

	private static final int PRODUCT_ID = 1;

	private static final int EXPECTED_LIST_SIZE = 1;

	@Mock
	private ProductService productService;
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testGetAllProducts() {
		List<Product> products = new ArrayList<>();
		products.add(new Product(PRODUCT_ID, PRODUCT_FACE, PRODUCT_PRICE, PRODUCT_SIZE));
		
		assertNotNull(products);
		
		when(productService.getAllProducts()).thenReturn(products);
		
		List<Product> productList = productService.getAllProducts();
		
		assertEquals(EXPECTED_LIST_SIZE, productList.size());
		
	}

	@Test
	public void testGetProductById() {
		
		Product product = new Product(PRODUCT_ID, PRODUCT_FACE, PRODUCT_PRICE, PRODUCT_SIZE);
		ProductByProductIdWrapper productByProductIdWrapper = new ProductByProductIdWrapper();
		productByProductIdWrapper.setProduct(product);
		
		assertNotNull(productByProductIdWrapper);
		
		when(productService.getProductById(PRODUCT_ID)).thenReturn(productByProductIdWrapper);
		
		ProductByProductIdWrapper productByProductId = productService.getProductById(PRODUCT_ID);
		
		assertEquals(PRODUCT_ID, productByProductId.getProduct().getId());
	}
}
