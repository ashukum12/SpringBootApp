package com.myapp.user.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.myapp.user.model.User;
import com.myapp.user.service.UserService;

@RestController
@RequestMapping(path = "/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping(path="/getUser", produces = "application/json")
	public List<User> getAllUser(){
		return userService.getAllUser();
	}
	
	@GetMapping(path="/getUser/{id}")
	public User getUserByid(@PathVariable int id) {
		return userService.getUserById(id);
	}
	
	@PostMapping("/addUser")
	public ResponseEntity<Void> createUser( @RequestBody User user) {
		User createdUser = userService.addUser(user);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdUser.getId())
				.toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteUSer(@PathVariable int id){
		User user = userService.deleteUserById(id);
		if (user != null) {
			return ResponseEntity.noContent().build();
		}

		return ResponseEntity.notFound().build();
	}

}
