package com.discount.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.discount.domain.User;
import com.discount.service.ErrorResponse;
import com.discount.service.UserService;
import com.discount.wrappers.UserByUserNameWrapper;

@RestController
public class UserController {

	private UserService userService;

	@Autowired
	public UserController(UserService userService) {
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
	public ResponseEntity<?> getUserByUserName(@PathVariable("userName") String userName) {
		if (!userService.isUserExist(userName)) {
			return new ResponseEntity<ErrorResponse>(new ErrorResponse("User with userName " + userName + " not found"), 
					HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<UserByUserNameWrapper>(userService.getUserByName(userName), HttpStatus.OK);
	}
}
