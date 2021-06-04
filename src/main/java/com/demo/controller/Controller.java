package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.entities.Gender;
import com.demo.entities.User;
import com.demo.service.IUserService;

@RestController
@RequestMapping("/registration")
public class Controller {
		
	@Autowired
	private IUserService userService;
	/*
	@PostMapping("/create")
	public void save(@RequestBody User user) {
		userService.save(user);
	}
	
	*/
	@PostMapping("/{userName, firstName, lastName, email, password}")
	//@RequestMapping(value = {"/ab"})
	public String save(@RequestParam String userName,@RequestParam String firstName, @RequestParam String lastName,@RequestParam Gender gender,@RequestParam String email,@RequestParam String password) {
		
		User user =userService.save( userName, firstName, lastName,gender, email, password);
		
		return "Registration successfull ..";
		
	}
	
	@GetMapping("/getDetails")
	public List<User> fetch(){
		return userService.fetchAll();
	}
}


