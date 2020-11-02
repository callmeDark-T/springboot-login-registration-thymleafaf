package com.tutorial.springcrud.web.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserRegistrationDto {
	
	private Long id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;

}
