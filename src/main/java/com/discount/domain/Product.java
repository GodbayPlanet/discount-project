package com.discount.domain;

public class Product {
	
	private Integer id;
	private String face;
	private Integer price;
	private Integer size;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFace() {
		return face;
	}

	public void setFace(String face) {
		this.face = face;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	@Override
	public String toString() {
		return "Product [" + (id != null ? "id=" + id + ", " : "")
				+ (face != null ? "face=" + face + ", " : "")
				+ (price != null ? "price=" + price + ", " : "")
				+ (size != null ? "size=" + size : "") + "]";
	}
	
}
