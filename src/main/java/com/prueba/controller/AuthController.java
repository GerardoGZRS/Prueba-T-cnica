package com.prueba.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.model.LoginRequest;
import com.prueba.model.LoginResponse;
import com.prueba.service.UserImplService;

import  org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api")
public class AuthController {

	private UserImplService implService;

	public AuthController(UserImplService implService) {
		this.implService = implService;
	}

	@PostMapping("login")
	ResponseEntity<?> login(@RequestBody LoginRequest login) {
		
		boolean b = implService.loginUser(login); 
		if (b == true) {
			return ResponseEntity.ok(new LoginResponse("Login Existoso"));
		} else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new LoginResponse("Credenciales inválidas"));
		}
	}

}
