package com.dailytasktracker.rest.webservices.rest.basic.auth;

public class AuthenticationBean {
	
	String message;
	
	AuthenticationBean(String message){
		this.message=message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
