package com.subham.emp_proj.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.subham.emp_proj.model.Users;
import com.subham.emp_proj.repository.UserRepo;

@Service
public class UserService {
	
	private UserRepo repo;
	private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(11);
	
	public UserService(UserRepo repo)
	{
		this.repo = repo;
	}
	
	public Users registerUser(Users user)
	{
		user.setPassword(encoder.encode(user.getPassword()));
		return repo.save(user);
	}

}
