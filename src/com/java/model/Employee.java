package com.java.model;

public class Employee {

	private String name;
	private String username;
	private String pass;
	
	public Employee(String name, String username, String pass) {
		super();
		this.name = name;
		this.username = username;
		this.pass = pass;
	}

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getUsername() {
		return username;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	@Override
	public String toString() {
		return "Employee [username=" + username + ", pass=" + pass + "]";
	}
	
	
}
