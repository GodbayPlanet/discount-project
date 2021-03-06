package com.discount.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.discount.DiscountProjectApplication;
import com.discount.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DiscountProjectApplication.class)
public class PurchaseControllerTest {

	private static final int INDEX = 2;

	@InjectMocks
	private PurchaseController purchaseController;

	@Autowired
	private WebApplicationContext context;

	@Autowired
	private UserService userService;

	private MockMvc mockMvc;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}

	/**
	 * This test will fail if there is no purchases by user at specified index.
	 * Data is generated with ./bin/generate-data.js file, and does not generate purchases for all users.
	 * So I made this test to practice unit testing.
	 * @throws Exception
	 */
	@Test
	@Ignore
	public void testGetListOfPurchasesByUser() throws Exception {
		String userName = userService.listOfUsers().get(INDEX).getUsername();

		mockMvc.perform(get("/api/purchases/by_user/" + userName))
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(jsonPath("$[" + INDEX + " ].username", is(userName)));
	}

}
