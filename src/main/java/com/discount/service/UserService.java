package com.discount.service;

import java.util.List;

import com.discount.domain.User;
import com.discount.wrappers.UserByUserNameWrapper;

public interface UserService {

	public List<User> listOfUsers();
	
	public UserByUserNameWrapper getUserByName(String userName);
	
	public boolean isUserExist(String userName);
}
