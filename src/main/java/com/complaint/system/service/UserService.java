package com.complaint.system.service;

import java.util.Optional;

//import java.util.Optional;

import org.springframework.stereotype.Service;

import com.complaint.system.model.User;
import com.complaint.system.repository.UserRepository;

@Service
public class UserService {

	final UserRepository repo;

	public UserService(UserRepository repo) {
		this.repo = repo;
	}
	
	public User register(User user) {
		return repo.save(user);
		
	}
	

	public Optional<User> login(String email, String password) {

	    Optional<User> useroutput = repo.findByEmail(email);

	   if(useroutput.isPresent() && useroutput.get().getPassword().equals(password))
	   {
		   return useroutput;
	   }
	   return Optional.empty();
	}

}

