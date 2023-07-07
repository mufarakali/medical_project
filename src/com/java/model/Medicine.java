package com.java.model;

public class Medicine {

	private String name;
	private Double price;
	private int qty;
	
	public Medicine() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Medicine(String name, Double price, int qty) {
		super();
		this.name = name;
		this.price = price;
		this.qty = qty;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	@Override
	public String toString() {
		return "Medicine [name=" + name + ", price=" + price + ", qty=" + qty + "]";
	}
	
	
	
	
	
}
