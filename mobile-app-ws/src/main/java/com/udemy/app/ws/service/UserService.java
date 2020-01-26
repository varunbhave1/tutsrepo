package com.udemy.app.ws.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.udemy.app.ws.shared.dto.UserDto;

public interface UserService extends UserDetailsService{

	UserDto createUser(UserDto userDto);
	
	UserDto getUser(String email);

	UserDto getUserByUserId(String id);

	UserDto updateUser(String userId, UserDto userDto);

	void deleteUserById(String id);

	List<UserDto> getUsers(int page, int limit);
	
}
