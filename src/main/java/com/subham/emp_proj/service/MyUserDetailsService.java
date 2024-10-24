package com.subham.emp_proj.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.subham.emp_proj.model.UserPrincipal;
import com.subham.emp_proj.model.Users;
import com.subham.emp_proj.repository.UserRepo;

@Service
public class MyUserDetailsService implements UserDetailsService{
	
	private UserRepo repo;
	
	public MyUserDetailsService(UserRepo repo)
	{
		this.repo = repo;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Users user = repo.findByUsername(username);
		
		if(user == null)
		{
			System.out.println("User Not Found!!");
			throw new UsernameNotFoundException("USer Not Found!");
		}
		return new UserPrincipal(user);
	}

}
