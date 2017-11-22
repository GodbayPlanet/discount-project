package com.discount.domain;

public class Purchase {

	private int id;
	private String username;
	private int productId;
	private String date;

	public Purchase() {}

	public Purchase(int id, String username, int productId, String date) {
		this.id = id;
		this.username = username;
		this.productId = productId;
		this.date = date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Purchase [id=" + id + ", "
				+ (username != null ? "username=" + username + ", " : "")
				+ "productId=" + productId + ", "
				+ (date != null ? "date=" + date : "") + "]";
	}

}
