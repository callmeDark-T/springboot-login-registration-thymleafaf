package com.tutorial.springcrud.service.impl;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.tutorial.springcrud.model.Role;
import com.tutorial.springcrud.model.User;
import com.tutorial.springcrud.repository.UserRepository;
import com.tutorial.springcrud.service.UserService;
import com.tutorial.springcrud.web.dto.UserRegistrationDto;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
	
	
	@Autowired
	private  UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Override
	public User save(UserRegistrationDto userRegistrationDto) {
		
		User user = new User(userRegistrationDto.getFirstName(), 
				userRegistrationDto.getLastName(), userRegistrationDto.getEmail(),
				passwordEncoder.encode(	userRegistrationDto.getPassword()), Arrays.asList(new Role("ROLE_USER")));
				
		
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = userRepository.findByEmail(username);
		
		if (user == null) {
			
			throw new UsernameNotFoundException("Invalid username or password ....."+username);
			
		}
		
		// TODO Auto-generated method stub
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), mapRolesAuthorities(user.getRoles()));
	}
	
	private Collection<? extends GrantedAuthority> mapRolesAuthorities(Collection<Role> roles){
		
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
		
		
		
	}

}
