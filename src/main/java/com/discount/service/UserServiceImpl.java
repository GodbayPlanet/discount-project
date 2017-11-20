package com.discount.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.discount.domain.User;
import com.discount.wrappers.UserWrapper;

@Service
public class UserServiceImpl implements UserService {
	
	private RestTemplate restTemplate;
	
	@Value("${discount.users}")
	private String usersURL;
	
	@Autowired
	public UserServiceImpl() {
		this.restTemplate = restTemplate();
	}

	/**
	 * This method returns list of users from server where all user data exists.
	 */
	@Override
	public List<User> listOfUsers() {
		UserWrapper userWrapper = restTemplate.getForObject(usersURL, UserWrapper.class);
		return userWrapper.getUsers();
	}

	/**
	 * Defining RestTemplate Bean.
	 * @return
	 */
	@Bean
	public RestTemplate restTemplate() {
	    return new RestTemplate();
	}
}
