package com.demo.service;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.demo.entities.User;
import com.demo.exception.ConfirmPassswordException;
import com.demo.exception.InvalidEmailAndPassword;
import com.demo.exception.UserDoesNotExist;
import com.demo.exception.UserEmailAlreadyExistException;
import com.demo.exception.UserNameException;

@Service
public interface IUserService {
	// for registration
	public User save(User user)throws UserEmailAlreadyExistException, UserNameException, ConfirmPassswordException;
	
	// for login
	public boolean findByEmailAndPassword(String email,String password) throws InvalidEmailAndPassword;

	// for deleting
	public void deleteUser(Long valueOf) throws UserDoesNotExist;

	// for updating
	public User updateUser(@Valid User user);

//	User getByEmail(String email) throws UserDoesNotExist;
	// by default ABSTRACT methods are public 
	
	// List<User> fetchAll();
	public User getByEmail(String email) throws UserDoesNotExist;
	 

}

