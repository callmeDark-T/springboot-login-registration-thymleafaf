package com.tutorial.springcrud.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.tutorial.springcrud.model.User;
import com.tutorial.springcrud.web.dto.UserRegistrationDto;

public interface UserService extends UserDetailsService {
	
	
	User save(UserRegistrationDto userRegistrationDto);

}
