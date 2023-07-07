package com.java.model;

public class Customer {

	private String name;
	private Double price;
	private int qty;
	private Double totalAmount;
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Customer(String name, Double price, int qty, Double totalAmount) {
		super();
		this.name = name;
		this.price = price;
		this.qty = qty;
		this.totalAmount = totalAmount;
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
	public Double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}
	@Override
	public String toString() {
		return "Customer [name=" + name + ", price=" + price + ", qty=" + qty + ", totalAmount=" + totalAmount + "]";
	}
	
	
}
