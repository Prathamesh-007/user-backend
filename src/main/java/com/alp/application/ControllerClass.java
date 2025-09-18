package com.alp.application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class ControllerClass {
	
	private static List<User> users = new ArrayList<>( 
		Arrays.asList (
			new User("Prathamesh", 101),
			new User("Ajay", 102),
			new User("Vijay", 103),
			new User("Sanjay", 104),
			new User("Dhananjay", 105)	
		)	
	);
	
	@RequestMapping("/hello")
	public String hello() {
		return "Hello World!";
	}
	
	@RequestMapping("/name/{name}")
	public String name(@PathVariable String name) {
		return "Hello " + name;
	}
	
	@RequestMapping("/allUsers")
	public List<User> allUsers() {
		return users;
	}
	
	@RequestMapping("/find/{id}")
	public User findById(@PathVariable Integer id) {
		for(User user: users) {
			if(user.getId().equals(id))
				return user;
		}
		
		return null;
			
	}

}
