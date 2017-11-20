package com.discount.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.discount.domain.User;
import com.discount.wrappers.UserWrapper;

@Service
public class UserServiceImpl implements UserService {

	@Override
	public List<User> listOfUsers() {
		RestTemplate restTemplate = new RestTemplate();
		UserWrapper userWrapper = restTemplate.getForObject("http://localhost:8000/api/users/", UserWrapper.class);
		
		return userWrapper.getUsers();
	}

}
