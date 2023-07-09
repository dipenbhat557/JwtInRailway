package com.newJwtAuthentication.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.newJwtAuthentication.Entities.User;
import com.newJwtAuthentication.Repo.UserRepo;


@Service
public class UserService {

//	private List<User> store = new ArrayList<>();

//	public UserService() {
//		store.add(new User(UUID.randomUUID().toString(), "Kiran", "Kiran@gmail.com"));
//		store.add(new User(UUID.randomUUID().toString(), "Pawan", "Pawan@gmail.com"));
//		store.add(new User(UUID.randomUUID().toString(), "Avaash", "Avaash@gmail.com"));
//		store.add(new User(UUID.randomUUID().toString(), "Rahul", "Rahul@gmail.com"));
//
//	}
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private UserRepo userRepo;
	
//	public List<User> getUsers(){
//		return this.store;
//	}
	
	public List<User> getUsers(){
		return this.userRepo.findAll();
	}
	
	public User createUser(User user) {
		user.setUserId(UUID.randomUUID().toString());
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return userRepo.save(user);
	}
}
