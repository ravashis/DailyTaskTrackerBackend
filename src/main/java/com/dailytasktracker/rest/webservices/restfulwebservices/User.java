package com.dailytasktracker.rest.webservices.restfulwebservices;

public class User {
	
	String hello;

	public User(String name) {
		super();
		this.hello = "Welcome "+name;
	}

	public String getHello() {
		return hello;
	}

	public void setHello(String name) {
		this.hello = "Welcome "+name;
	}
	
	

}
