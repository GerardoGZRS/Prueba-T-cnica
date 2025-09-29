package com.prueba.model;

import lombok.Data;

@Data
public class LoginResponse {

	
	private String message;

	public LoginResponse(String message) {
		super();
		this.message = message;
	}
	
	
}
