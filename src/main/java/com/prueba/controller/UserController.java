package com.prueba.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.dto.UserDto;
import com.prueba.model.LoginResponse;
import com.prueba.model.User;
import com.prueba.model.UserResponse;
import com.prueba.service.UserImplService;

@RestController
@RequestMapping("/api")
public class UserController {

	// @Autowired
	private final UserImplService implService;
	
	

    public UserController(UserImplService implService) {
        this.implService = implService;
    }

	@PostMapping("createUser")
	public ResponseEntity<UserDto> postMethodName(@RequestBody User entity)  {

		try {
			return ResponseEntity.ok(implService.createUser(entity));
		} catch (IllegalArgumentException e) {
			return ResponseEntity.badRequest().build();
		} 
	}
	
	@PatchMapping("/{id}")
	public ResponseEntity<UserDto> updateMethodName(@PathVariable String id, @RequestBody User entity) {

		try {
			return ResponseEntity.ok(implService.updateUser(id, entity));
		} catch (IllegalArgumentException e) {
			System.out.println("error " + e.getMessage());
			return ResponseEntity.badRequest().build();
		}
	}
	
	@GetMapping("getById/{id}")
	public ResponseEntity<User> getMethodName(@PathVariable String id) {

		try {
			return ResponseEntity.ok(implService.byId(id));
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}
	
	@DeleteMapping("users/{id}")
	public ResponseEntity<?> deleteMethodName(@PathVariable String id) {
		
		boolean b = implService.deleteUser(id);
		if(b==true) {
		
			return ResponseEntity.ok(new UserResponse("Usuario eliminado con exito"));
	}else {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new UserResponse("Usuario no existe"));
		}
	}
	
	
	@GetMapping("/users/{id}")
    public ResponseEntity<List<User>> getUserById( @RequestParam(required = false) String sortedBy,
            @RequestParam(required = false, defaultValue = "asc") String order) {
		try {
			return ResponseEntity.ok(implService.getUserById(sortedBy, order));
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
    }
	
	@GetMapping("/users/filter")
    public ResponseEntity<List<User>> getFiltered(@RequestParam String filter) {
        List<User> resultado = implService.filterUsers(filter);
        return ResponseEntity.ok(resultado);
    }

}
