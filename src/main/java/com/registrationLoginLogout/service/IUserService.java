package com.registrationLoginLogout.service;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.registrationLoginLogout.entities.User;
import com.registrationLoginLogout.exception.ConfirmPassswordException;
import com.registrationLoginLogout.exception.InvalidEmailAndPassword;
import com.registrationLoginLogout.exception.UserDoesNotExist;
import com.registrationLoginLogout.exception.UserEmailAlreadyExistException;
import com.registrationLoginLogout.exception.UserNameException;

@Service
public interface IUserService {
	//Interface  for registration
	public User save(User user)throws UserEmailAlreadyExistException, UserNameException, ConfirmPassswordException;
	
	//Interface for login
	public boolean findByEmailAndPassword(String email,String password) throws InvalidEmailAndPassword;

	//Interface for deleting
	public void deleteUser(Long valueOf) throws UserDoesNotExist;

	//Interface for updating
	public User updateUser(@Valid User user);

	// interface for Fetch By Email
	public User getByEmail(String email) throws UserDoesNotExist;
	 

}

