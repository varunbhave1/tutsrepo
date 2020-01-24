package com.udemy.app.ws.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.udemy.app.ws.shared.dto.UserDto;

public interface UserService extends UserDetailsService{

	UserDto createUser(UserDto userDto);
	
	UserDto getUser(String email);

	UserDto getUserByUserId(String id);
	
}
