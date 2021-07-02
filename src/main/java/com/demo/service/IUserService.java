package com.demo.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.demo.entities.User;
import com.demo.exception.InvalidEmailAndPassword;
import com.demo.exception.UserDoesNotExist;
import com.demo.exception.UserEmailAlreadyExistException;
import com.demo.exception.UserNameException;

@Service
public interface IUserService {
	
	public User save(User user)throws UserEmailAlreadyExistException, UserNameException;
	
	// by default ABSTRACT methods are public 
	
	 List<User> fetchAll();
	 
	 public User findByUserName(String userName) throws  UserDoesNotExist;

	public List<User> findAll();
	
	public boolean findByEmailAndPassword(String email,String password) throws InvalidEmailAndPassword;

//	public User getById(String email) throws UserDoesNotExist;

	public void deleteUser(Long valueOf) throws UserDoesNotExist;

	public User updateUser(@Valid User user);

	User getByEmail(String email) throws UserDoesNotExist;
	 

}

//  public interface IUserService extends UserDetailsService{