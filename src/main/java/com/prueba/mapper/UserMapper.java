package com.prueba.mapper;

import com.prueba.dto.UserDto;
import com.prueba.model.User;

public class UserMapper {
	
	public UserMapper() {
		
	}
	
	public static UserDto userCreate(User user) {
		UserDto dto = new UserDto();
		dto.setId(user.getId());
		dto.setEmail(user.getEmail());
		dto.setPhone(user.getPhone());
		dto.setName(user.getName());
		dto.setTaxid(user.getTaxid());
		dto.setAdress(user.getAdress());
		dto.setCreatedat(user.getCreatedat());
		return dto;
	}
	
	public static UserDto userUpdate(User user) {
		UserDto dto = new UserDto();
		dto.setId(user.getId());
		dto.setEmail(user.getEmail());
		dto.setPhone(user.getPhone());
		dto.setName(user.getName());
		dto.setTaxid(user.getTaxid());
		dto.setAdress(user.getAdress());
		dto.setCreatedat(user.getCreatedat());
		return dto;
	}

}
