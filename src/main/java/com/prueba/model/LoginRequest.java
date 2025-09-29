package com.prueba.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class LoginRequest {
	
	@JsonProperty("tax_id")
	private String taxId;
	@JsonProperty("password")
	private String password;
	
	public LoginRequest() {
		super();
	}

	public String getTaxId() {
		return taxId;
	}

	public void setTaxId(String taxId) {
		this.taxId = taxId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	

}
