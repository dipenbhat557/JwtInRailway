package com.newJwtAuthentication.Repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.newJwtAuthentication.Entities.User;

public interface UserRepo extends JpaRepository<User, String>{

	public Optional<User> findByEmail(String email);
	
}
