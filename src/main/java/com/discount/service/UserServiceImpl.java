package com.discount.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.discount.domain.User;
import com.discount.wrappers.UserByUserNameWrapper;
import com.discount.wrappers.UserWrapper;

@Service
public class UserServiceImpl implements UserService {

	private RestTemplate restTemplate;

	@Value("${discount.usersURL}")
	private String usersURL;

	@Value("${discount.userByUserNameURL}")
	private String userByUserNameURL;

	@Autowired
	public UserServiceImpl() {
		this.restTemplate = RESTemplate.restTemplate();
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
	 * Method returns User from server.
	 */
	@Override
	public UserByUserNameWrapper getUserByName(String userName) {
		 UserByUserNameWrapper user = restTemplate.getForObject(userByUserNameURL.replace("{userName}", userName), UserByUserNameWrapper.class);
		 return user;
	}

	/**
	 * Method returns true if user with given userName exist in user list.
	 */
	@Override
	public boolean isUserExist(String userName) {
		List<User> users = listOfUsers();
		return users.stream().anyMatch(user -> user.getUsername().equals(userName));
	}

}
