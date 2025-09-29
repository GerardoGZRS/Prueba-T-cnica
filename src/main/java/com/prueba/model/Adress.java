package com.prueba.model;

import lombok.Data;

@Data
public class Adress {

	public Adress() {
		// TODO Auto-generated constructor stub
	}

	private Integer id;
	private String name;
	private String street;
	private String countryCode;

	public Adress(Integer id, String name, String street, String countryCode) {
		super();
		this.id = id;
		this.name = name;
		this.street = street;
		this.countryCode = countryCode;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	
	

}
