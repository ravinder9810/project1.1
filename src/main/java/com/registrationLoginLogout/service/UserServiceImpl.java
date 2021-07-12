 package com.registrationLoginLogout.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.registrationLoginLogout.entities.User;
import com.registrationLoginLogout.exception.ConfirmPassswordException;
import com.registrationLoginLogout.exception.InvalidEmailAndPassword;
import com.registrationLoginLogout.exception.UserDoesNotExist;
import com.registrationLoginLogout.exception.UserEmailAlreadyExistException;
import com.registrationLoginLogout.exception.UserNameException;
import com.registrationLoginLogout.repository.UserRepository;


@Service
public  class UserServiceImpl implements IUserService{
	
	Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	private UserRepository userRepository;
	
	// For Registration 
	@Override	
	public User save( User user ) throws UserEmailAlreadyExistException, UserNameException, ConfirmPassswordException 
	{
	
	if(checkIfEmailExist(user.getEmailId()))
	{
		logger.info(" user exist the Mail-Id ");
		logger.info(" please try with another Mail-Id ");
		throw new UserEmailAlreadyExistException();
		// throwing exception if user exist with same mail-Id
	}
	if(checkIfUserNameExist(user.getUserName())) 
	{
		logger.info(" user exist the UserName ");
		logger.info(" please try with another UserName");
		throw new UserNameException();
		// throwing exception if user exist with same UserName
	}
	if(!(user.getPassword().equals(user.getConfirmPassword())))
	{
		logger.info(" password and confirm password does not match exception occured ");
		throw new ConfirmPassswordException();
		// throwing exception if password and confirm password does not match
	}
	
	logger.info(user.getFirstName() +  " you had successfully registered ");
		return	userRepository.save(user);
	}
	
	// this is for registration 
	//check with mail
	public boolean checkIfEmailExist(String email) {
		return userRepository.findByEmailId(email) != null ? true : false;
	}
	
	//this is for registration
	// check with username
	public boolean checkIfUserNameExist(String userName) {
		return userRepository.findByUserName(userName) != null ? true : false;
	}
	

	// this is for Login user with email and password
	@Override
	public boolean findByEmailAndPassword(String email, String password) throws InvalidEmailAndPassword {
		Optional<User> user =userRepository.findByEmailIdAndPassword(email, password);
		if(!user.isPresent()){
			logger.info("Invalid UserName and Password Exception occured ");
			throw new InvalidEmailAndPassword();
		}
		
		return userRepository.findByEmailIdAndPassword(email, password) != null ? true:false;
	}


	// fetching user by email-Id
	@Override
	public User getByEmail(String email) throws UserDoesNotExist  {
		
		Optional<User> user=Optional.ofNullable(userRepository.findByEmailId(email));
		if(!user.isPresent()) 
		{
			logger.info(" fetching user details after logged-In ");
			throw new UserDoesNotExist(); 
		}
		
		return user.get();
	}
	
//
//	@Override
//	public void deleteUser(Long id) throws UserDoesNotExist {
//		Optional<User> user = userRepository.findById(id);
//		if(!user.isPresent())
//		{
//			throw new UserDoesNotExist();
//		}
//		userRepository.deleteById(id);
//		
//	}
//
//	@Override
//	public User updateUser(@Valid User user) {
//		
//		return userRepository.save(user);
//	}

}
