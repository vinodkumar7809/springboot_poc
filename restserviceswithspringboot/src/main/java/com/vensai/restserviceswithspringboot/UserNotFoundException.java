package com.vensai.restserviceswithspringboot;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class UserNotFoundException extends RuntimeException {

	public UserNotFoundException(String messages) {
		super(messages);
	}
	
}
