package com.complaint.system.controller;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.complaint.system.dto.AuthResponse;
import com.complaint.system.model.User;
import com.complaint.system.service.UserService;

@RestController
@CrossOrigin
@RequestMapping("/api/auth")
public class AuthController {

	final UserService service;
	
	public AuthController(UserService service){
		this.service = service;
		
	}
	
	@PostMapping("/register")
	public ResponseEntity<AuthResponse> register(@RequestBody User user) {
		User saveduser = service.register(user);
		AuthResponse response = new AuthResponse("User register Sucessfully !!",saveduser.getId(),saveduser.getRole());
		
		return ResponseEntity.ok(response);
	}
	
	
	@PostMapping("/login")
	public ResponseEntity<AuthResponse> login(@RequestBody User user) {

		 Optional<User> loggedUser =
		            service.login(user.getEmail(), user.getPassword());

	    if (loggedUser.isEmpty()) {
	        return  ResponseEntity.ok(new AuthResponse("Invalid email or password !!", null,null));
	    }
	    User dbuser = loggedUser.get();
	    return ResponseEntity.ok( new AuthResponse("Login Sucess fully !!", dbuser.getId(),dbuser.getRole()));
	}


	
}
