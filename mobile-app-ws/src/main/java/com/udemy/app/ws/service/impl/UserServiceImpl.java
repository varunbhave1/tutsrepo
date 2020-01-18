package com.udemy.app.ws.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.udemy.app.ws.io.entity.UserEntity;
import com.udemy.app.ws.repository.UserRepository;
import com.udemy.app.ws.service.UserService;
import com.udemy.app.ws.shared.dto.UserDto;
import com.udemy.app.ws.shared.Utils;


/* @Service : This annotation serves as a specialization of @Component,
 * 			  allowing for implementation classes to be auto-detected through class-path scanning.
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	Utils utils;
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Override
	public UserDto createUser(UserDto userDto) {
		
		
		if( userRepository.findByEmail(userDto.getEmail()) != null) {
			throw new RuntimeException("Record with this email already exists !");
		}
		
		UserEntity userEntity = new UserEntity();
		
		//copy the userDTO details to userEntity.
		BeanUtils.copyProperties(userDto, userEntity);
		
		userEntity.setEncryptedPassword(bCryptPasswordEncoder.encode(userDto.getPassword())); 
		userEntity.setUserId(utils.generateUserId(30)); 
		
		//persists user to database.
		
		UserEntity storedUserDetails = userRepository.save(userEntity);
		UserDto userDtoReturnValue = new UserDto(); 
		
		//copy the saved user entity details to response object.
		BeanUtils.copyProperties(storedUserDetails, userDtoReturnValue);
		
		return userDtoReturnValue;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	
		return null;
	}

}
