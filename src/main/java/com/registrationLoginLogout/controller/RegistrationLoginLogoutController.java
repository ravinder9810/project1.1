package com.registrationLoginLogout.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
import com.registrationLoginLogout.service.UserServiceImpl;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("/registration")
public class RegistrationLoginLogoutController {
		
	@Autowired									// Injecting userservice interface because we are going to use methods inside the userservice interface
	private IUserService userService;
	
	Logger logger = LoggerFactory.getLogger(RegistrationLoginLogoutController.class);
		//for Registration 
	@PostMapping("registration")
	public ResponseEntity<User> registerUserAccount(@Valid @RequestBody User user) throws UserEmailAlreadyExistException, UserNameException, ConfirmPassswordException
	{
		logger.info("inside registration controller ");
		User user1 = userService.save(user);
		
		return new ResponseEntity<User>(HttpStatus.CREATED);
	}	
	

	
	@PostMapping("login")
	public ResponseEntity<Login>  login(@RequestBody  Login login) throws InvalidEmailAndPassword
	{
		String email= login.getEmailId();
		String pwd = login.getPassword();
		
		
		if(userService.findByEmailAndPassword(email, pwd)==false) 
		{
			throw new InvalidEmailAndPassword();
		}
		logger.info("inside login controller ");
		return new ResponseEntity<Login>(login, HttpStatus.CREATED);
	}
	
	
	
	
	@GetMapping("user/{email}")
	public User getUserDetails(@PathVariable String email) throws UserDoesNotExist{
		User user=userService.getByEmail(email);
		return user;
		
	}
	
//	@DeleteMapping("delete/{id}")
//	public ResponseEntity<Void> deleteById(@PathVariable String id) throws UserDoesNotExist{
//		
//		userService.deleteUser(Long.valueOf(id));
//		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
//		
//	}
//	
//		
//	
//	@PutMapping("/update")
//	@ApiOperation("update customer details ")
//	public User update(@Valid @RequestBody User user) {
//		
//		return userService.updateUser(user);
//		
//	}

	
}


