package com.discount.wrappers;

import java.util.ArrayList;
import java.util.List;

import com.discount.domain.User;

public class UserWrapper {

	private List<User> users;
	
	public UserWrapper() {
		users = new ArrayList<>();
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
}
