package com.prueba.model;

import lombok.Data;

@Data
public class UserResponse {
	
	@SuppressWarnings("unused")
	private String message;

	public UserResponse(String message) {
		super();
		this.message = message;
	}
	

}
