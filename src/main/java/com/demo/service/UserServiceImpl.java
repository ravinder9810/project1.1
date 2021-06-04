package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.entities.Gender;
import com.demo.entities.User;
import com.demo.repository.UserRepository;


@Service
public class UserServiceImpl implements IUserService{
	
	@Autowired
	private UserRepository userRepository;
	
	/*@Autowired
	private BCryptPasswordEncoder passwordEncoder;
*/
	@Override
	public User save( String userName, String firstName, String secondName,Gender gender,String email, String password )
	{
		User user = new User();
		user.setUserName(userName);
		user.setFirstName(firstName);
		user.setSecondName(secondName);
		
		user.setGender(gender);
		
		user.setEmail(email);
		user.setPassword(password);
	//	userRepository.save(user);
		return userRepository.save(user);
		
	}

	@Override
	public List<User> fetchAll() {

		return userRepository.findAll();
	}

	
}
