package com.newJwtAuthentication.Controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.newJwtAuthentication.Entities.User;
import com.newJwtAuthentication.Service.UserService;

@RestController
@RequestMapping("/home")
public class HomeController {
	
	@Autowired
	private UserService userService;

	@GetMapping("/user")
	public List<User> getUser() {
		this.userService.getUsers().forEach(user->System.out.println(user));
		System.out.println("Getting users");
		return this.userService.getUsers();
	}
	
	@GetMapping("/currentUser")
	public String getLoginUser(Principal principal) {
		
		return principal.getName();
	}
}
