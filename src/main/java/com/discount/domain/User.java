package com.discount.domain;

public class User {

	private String username;
	private String email;
	
	public User() {}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "User ["
				+ (username != null ? "username=" + username + ", " : "")
				+ (email != null ? "email=" + email : "") + "]";
	}
}
