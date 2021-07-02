package com.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByUserName(String userName);

	Optional<User> findByEmail(String email);
	
	//User findByEmail(String email);
	//public User save(String userName,String firstName, String secondName, String email, String password);

	Optional<User> findByEmailAndPassword(String email , String password);
}
