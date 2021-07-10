package com.registrationLoginLogout.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.registrationLoginLogout.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByUserName(String userName);
	
	User findByEmailId(String email);
	
	Optional<User> findByEmailIdAndPassword(String email , String password);
}
