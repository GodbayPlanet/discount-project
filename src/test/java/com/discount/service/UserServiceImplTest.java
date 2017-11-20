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

@RunWith(SpringRunner.class)
//Need this for reading the values from test property file
@TestPropertySource(locations = "classpath:application.properties")
public class UserServiceImplTest {

	@Mock
	private UserService userService;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testListOfUsers() {
		List<User> users = new ArrayList<>();
		users.add(new User("Pero", "pero@gmail.com"));
		users.add(new User("Zdero", "ydero@gmail.com"));
		users.add(new User("Peric", "peric@gmail.com"));

		assertNotNull(users);

		when(userService.listOfUsers()).thenReturn(users);

		List<User> usersReturned = userService.listOfUsers();

		assertEquals(3, usersReturned.size());
	}

	@Test
	public void testRestTemplate() {
		UserServiceImpl userServiceImpl = new UserServiceImpl();
		RestTemplate restTemplate = userServiceImpl.restTemplate();

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
