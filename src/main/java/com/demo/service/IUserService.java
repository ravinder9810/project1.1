package com.demo.service;

import java.sql.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.demo.entities.Gender;
import com.demo.entities.User;

@Service
public interface IUserService {
	
	public User save(String userName,String firstName, String secondName,Gender gender, String email, String password);
	public List<User> fetchAll();

}