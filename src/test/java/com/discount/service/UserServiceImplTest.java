package com.discount.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.discount.domain.User;
import com.discount.wrappers.UserByUserNameWrapper;

@RunWith(SpringRunner.class)
//Need this for reading the values from test property file
@TestPropertySource(locations = "classpath:application.properties")
public class UserServiceImplTest {

	private static final int EXPECTED_LIST_SIZE = 3;
	private static final String USER_EMAIL_PERIC = "peric@gmail.com";
	private static final String USER_EMAIL_ZDERO = "ydero@gmail.com";
	private static final String USER_EMAIL_PERO = "pero@gmail.com";
	private static final String USER_PERIC = "Peric";
	private static final String USER_ZDERO = "Zdero";
	private static final String USER_PERO = "Pero";
	private static final String USER_EMAIL_NENAD = "nenadovic@gmail.com";
	private static final String USER_NENAD = "Nenad";
	
	@Mock
	private UserService userService;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testListOfUsers() {
		List<User> users = new ArrayList<>();
		users.add(new User(USER_PERO, USER_EMAIL_PERO));
		users.add(new User(USER_ZDERO, USER_EMAIL_ZDERO));
		users.add(new User(USER_PERIC, USER_EMAIL_PERIC));

		assertNotNull(users);

		when(userService.listOfUsers()).thenReturn(users);

		List<User> usersReturned = userService.listOfUsers();

		assertEquals(EXPECTED_LIST_SIZE, usersReturned.size());
	}
	
	@Test
	public void testGetUserByName() {
		User user = new User(USER_NENAD, USER_EMAIL_NENAD);
		UserByUserNameWrapper userByUserNameWrapper = new UserByUserNameWrapper();
		userByUserNameWrapper.setUser(user);
		
		assertNotNull(userByUserNameWrapper);
		
		when(userService.getUserByName(USER_NENAD)).thenReturn(userByUserNameWrapper);
		
		UserByUserNameWrapper userByUserName = userService.getUserByName(USER_NENAD);
		
		assertEquals(USER_NENAD, userByUserName.getUser().getUsername());
	}

	@Test
	public void testRestTemplate() {
		RestTemplate restTemplate = RESTemplate.restTemplate();

		assertNotNull(restTemplate);
	}

	/**
	 * This static class is added in order to populate fields with @Value annotation.
	 * @author Nemanja Vasic
	 *
	 */
	@Configuration
	public static class Config {
		@Bean
		public static PropertySourcesPlaceholderConfigurer propertyConfigurer() {
			return new PropertySourcesPlaceholderConfigurer();
		}
	}
}
