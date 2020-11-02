package com.tutorial.springcrud.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import com.tutorial.springcrud.service.UserService;
import com.tutorial.springcrud.web.dto.UserRegistrationDto;

@Controller
@RequestMapping("/registration")
public class UserRegistrationController {
	
	private UserService userService;

	public UserRegistrationController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	// thymleaf object link to user registration dto
	@ModelAttribute("user")
	public UserRegistrationDto  userRegistrationDto() {
		
		return new UserRegistrationDto();
	}
	
	
	@GetMapping
	public String showRegistrationForm() {
		
		
		return "registration";
	}
	
	
	@PostMapping
	public String registerUserAccount(@ModelAttribute("user") UserRegistrationDto userRegistrationDto) {
	
		userService.save(userRegistrationDto);
		
		return "redirect:/registration?success";
	
	}
	
	
	

}
