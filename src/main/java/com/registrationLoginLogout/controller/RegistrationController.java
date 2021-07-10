package com.registrationLoginLogout.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.registrationLoginLogout.entities.Login;
import com.registrationLoginLogout.entities.User;
import com.registrationLoginLogout.exception.ConfirmPassswordException;
import com.registrationLoginLogout.exception.InvalidEmailAndPassword;
import com.registrationLoginLogout.exception.UserDoesNotExist;
import com.registrationLoginLogout.exception.UserEmailAlreadyExistException;
import com.registrationLoginLogout.exception.UserNameException;
import com.registrationLoginLogout.service.IUserService;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("/registration")
public class RegistrationController {
		
	@Autowired
	private IUserService userService;
	

		//for Registration 
	@PostMapping("registration")
	public ResponseEntity<User> registerUserAccount(@Valid @RequestBody User user) throws UserEmailAlreadyExistException, UserNameException, ConfirmPassswordException
	{
				
		User user1 = userService.save(user);
		
		return new ResponseEntity<User>(user1,HttpStatus.CREATED);
	}	
	

	
	@PostMapping("login")
	public ResponseEntity<Login>  login(@RequestBody  Login login,HttpSession session) throws InvalidEmailAndPassword
	{
		String email= login.getEmailId();
		String pwd = login.getPassword();
		
		
		if(userService.findByEmailAndPassword(email, pwd)==false) 
		{
			throw new InvalidEmailAndPassword();
		}
				
		return new ResponseEntity<>(login, HttpStatus.CREATED);
	}
	
	
	
	
	@GetMapping("user/{email}")
	public User getUserDetails(@PathVariable String email) throws UserDoesNotExist{
		User user=userService.getByEmail(email);
		return user;
		
	}
	
	@DeleteMapping("delete/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable String id) throws UserDoesNotExist{
		
		userService.deleteUser(Long.valueOf(id));
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		
	}
	
		
	
	@PutMapping("/update")
	@ApiOperation("update customer details ")
	public User update(@Valid @RequestBody User user) {
		
		return userService.updateUser(user);
		
	}

	
}


