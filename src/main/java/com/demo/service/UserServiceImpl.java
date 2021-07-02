 package com.demo.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.entities.User;
import com.demo.exception.InvalidEmailAndPassword;
import com.demo.exception.UserDoesNotExist;
import com.demo.exception.UserEmailAlreadyExistException;
import com.demo.exception.UserNameException;
import com.demo.repository.UserRepository;


@Service
public  class UserServiceImpl implements IUserService{
	
	@Autowired
	private UserRepository userRepository;
	
//	@Autowired
//	private BCryptPasswordEncoder passwordEncoder
	
	@Override
	public User save( User user ) throws UserEmailAlreadyExistException, UserNameException 
	{
	
	//	user.setPassword(passwordEncoder.encode(user.getPassword()));
	if(!checkIfEmailExist(user.getEmail()))
	{
		throw new UserEmailAlreadyExistException();
	}
	if(!checkIfUserNameExist(user.getUserName())) {
		throw new UserNameException();
		
	}
	
//	BCryptPasswordEncoder enc = new BCryptPasswordEncoder();
//	user.setPassword(enc.encode(user.getPassword()));
	user.setRoll("Trainee");
		
		return	userRepository.save(user);
	}
	
	//check with mail
	public boolean checkIfEmailExist(String email) {// this is for registration 
		return userRepository.findByEmail(email) != null ? true : false;
	}

	// check with username
	public boolean checkIfUserNameExist(String userName) {//this is for registration
		return userRepository.findByUserName(userName) != null ? true : false;
	}
	

	@Override
	public List<User> fetchAll() // get all users details
	{
		List<User> user = userRepository.findAll();			
		return user;	
		
	}

	@Override
	public User findByUserName(String userName) throws UserDoesNotExist {
		User user = userRepository.findByUserName(userName);
		
		
		User user1 = new User();
		 
		user1.setUserName(user.getUserName());
		user1.setRoll(user.getRoll());
		user1.setEmail(user.getEmail());
		
		return user1;
			
	}
	

	@Override
	public boolean findByEmailAndPassword(String email, String password) throws InvalidEmailAndPassword {
		Optional<User> user =userRepository.findByEmailAndPassword(email, password);
		if(!user.isPresent()){
			throw new InvalidEmailAndPassword();
		}
		
		return userRepository.findByEmailAndPassword(email, password) != null ? true:false;
	}



	@Override
	public User getByEmail(String email) throws UserDoesNotExist  {
		
		Optional<User> user=userRepository.findByEmail(email);
		if(!user.isPresent()) 
		{
			throw new UserDoesNotExist(); 
		}
		
		return user.get();
	}
	@Override
	public List<User> findAll() {
		
		
		return userRepository.findAll();
		
	}
	
	


	@Override
	public void deleteUser(Long id) throws UserDoesNotExist {
		Optional<User> user = userRepository.findById(id);
		if(!user.isPresent())
		{
			throw new UserDoesNotExist();
		}
		userRepository.deleteById(id);
		
	}

	
	

	@Override
	public User updateUser(@Valid User user) {
		
		return userRepository.save(user);
	}

	

	




	
}
