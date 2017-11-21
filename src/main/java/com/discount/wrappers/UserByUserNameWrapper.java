package com.discount.wrappers;

import com.discount.domain.User;

public class UserByUserNameWrapper {

	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "UserByUserName [" + (user != null ? "user=" + user : "") + "]";
	}

}
