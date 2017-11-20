package com.discount.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.discount.domain.User;
import com.discount.service.UserService;

@RestController
public class DiscountController {

	private UserService userService;

	@Autowired
	public DiscountController(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping("/api/users")
	public List<User> getUsers() {
		return userService.listOfUsers();
	}
}
