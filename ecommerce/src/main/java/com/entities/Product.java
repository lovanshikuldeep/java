package com.entities;

public class Product {
	protected int id;
	protected String type;
	protected String brand;
	protected String price;
	protected String size;

	public Product(String type, String brand, String price, String size) {

	}

	public Product(int id) {
		this.id = id;
	}

	public Product(int id, String type, String brand, String price, String size) {
		super();
		this.id = id;
		this.type = type;
		this.brand = brand;
		this.price = price;
		this.size = size;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

}
