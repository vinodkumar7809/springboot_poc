package com.vensai.restserviceswithspringboot.helloworld;


public class User {
	
	private String message;
	
	public User(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
