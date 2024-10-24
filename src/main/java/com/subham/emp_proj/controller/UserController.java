package com.subham.emp_proj.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.subham.emp_proj.model.Users;
import com.subham.emp_proj.service.UserService;

@RestController
public class UserController {
	
	private UserService service;
	
	public UserController(UserService service)
	{
		this.service = service;
	}
	
	@PostMapping("/register")
	public ResponseEntity<String> registerUser(@RequestBody Users user)
	{
		try
		{
			service.registerUser(user);
			return new ResponseEntity<>("User Registered Successfully", HttpStatus.CREATED);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>("Unable to register!", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
