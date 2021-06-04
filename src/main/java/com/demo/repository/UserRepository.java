package com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.entities.User;

public interface UserRepository extends JpaRepository<User, String> {
	
	//public User save(String userName,String firstName, String secondName, String email, String password);

}
