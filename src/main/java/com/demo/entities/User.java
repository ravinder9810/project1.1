package com.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "regis_table", uniqueConstraints = { @ UniqueConstraint(columnNames = "email"), @UniqueConstraint(columnNames = "userName")})	
//@Table(name = "regis_table", uniqueConstraints =  @ UniqueConstraint(columnNames = {"userName","email"})	)	

public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
//	@Size(min = 4 , message  = "shoud have mini 4 chars !")
	@Column(name = "userName" , unique = true , nullable = false)
	private String userName;
		
	@NotNull
	//@Size(min = 4, message = "firstName shoud have mini 4 chars !")
	private String firstName;
	
	/*
	@ApiModelProperty(required = true, dataType = "java.sql.Date")
	@Pattern(regexp = "yyyy-MM-dd")
	private Date mCreatedAt;
	*/
	@NotNull
//	@Size(min = 4, message = "secondName shoud have mini 4 chars !")
	private String secondName;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "gender")
	private Gender gender;
	
	
	//@Pattern(regexp = "[a-zA-Z0-9+_]+@[a-zA-Z0-9.-]")
	@Column(name = "email" , unique = true , nullable = false)
	private String email;
	
//	@Size(min = 8 ,message = " password should have minimum 8 characters ")
	@NotNull
	private String password;
	
	
	
	

}
