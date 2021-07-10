package com.registrationLoginLogout.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "registration_Table")


public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Size(min = 4 , message  = "User-Name should have minimum 4 characters ")
	private String userName;
		
	@NotNull
	@Size(min = 4, message = "FirstName should have minimun 4 characters ")
	private String firstName;
	

	
	@NotNull
	@Size(min = 4, message = "LastName should have minimum 4 characters ")
	private String lastName;
	
	@Column(name = "gender")
	private String gender;
	
	
	@Column(name = "address")
	private String address;
	
	@Pattern(regexp = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z]+(?:\\.[a-zA-Z0-9-]+)*$",message = "Please Enter a Valid Email-Id ")
	private String emailId;
	

	@Column(name = "password")
//	@Size(min = 8 ,message = " password should have minimum 8 characters ")
	@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$" ,message = "Password should contain minimun 8 characters (combination of One Alphabet Uppercase , Lowercase One Numeric and One special character)")
	private String password;
	
	@Column(name = "confirmPassword")
	@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$" ,message = "Confirm Password should contain minimun 8 characters ")
	private String confirmPassword;
		

	
	
}
