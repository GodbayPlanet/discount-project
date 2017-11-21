package com.discount.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.discount.domain.User;
import com.discount.service.UserService;
import com.discount.wrappers.UserByUserNameWrapper;

@RestController
public class DiscountController {

	private UserService userService;

	@Autowired
	public DiscountController(UserService userService) {
		this.userService = userService;
	}

	/**
	 * Method use UserService interface to return list of users from server.
	 * @return
	 */
	@RequestMapping("/api/users")
	public List<User> getUsers() {
		return userService.listOfUsers();
	}
	
	/**
	 * Method returns User based on the given userName.
	 * @param userName
	 * @return
	 */
	@RequestMapping("/api/users/{userName}")
	public UserByUserNameWrapper getUserByUserName(@PathVariable("userName") String userName) {
		return userService.getUserByName(userName);
	}
}
