package com.prueba.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.prueba.model.Adress;

import lombok.Data;

@Data
public class UserDto {
	
	@JsonProperty("id")
	private String id;
	@JsonProperty("email")
	private String email;
	@JsonProperty("name")
	private String name;
	@JsonProperty("phone")
	private String phone;
	@JsonProperty("tax_Id")
	private String taxid;
	@JsonProperty("created_At")
	private String createdat;
	@JsonProperty("addresses")
	private List<Adress> adress;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getTaxid() {
		return taxid;
	}
	public void setTaxid(String taxid) {
		this.taxid = taxid;
	}
	public String getCreatedat() {
		return createdat;
	}
	public void setCreatedat(String createdat) {
		this.createdat = createdat;
	}
	public List<Adress> getAdress() {
		return adress;
	}
	public void setAdress(List<Adress> adress) {
		this.adress = adress;
	}
	
	

}
