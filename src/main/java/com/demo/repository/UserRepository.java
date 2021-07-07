package com.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByUserName(String userName);

	//Optional<User> findByEmail(String email);
	
	User findByEmailId(String email);
	
	Optional<User> findByEmailIdAndPassword(String email , String password);
}
