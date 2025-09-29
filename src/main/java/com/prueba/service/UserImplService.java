package com.prueba.service;

import java.util.List;

import com.prueba.dto.UserDto;
import com.prueba.model.LoginRequest;
import com.prueba.model.User;

public interface UserImplService {
	
	
	UserDto createUser(User user);
	UserDto updateUser(String id, User user);
	boolean deleteUser(String ser);
	  User byId(String id);
	 

		boolean loginUser(LoginRequest login);

	List<User> getUserById(String sortedBy, String order);
	
	List<User> filterUsers(String filter); 
}
