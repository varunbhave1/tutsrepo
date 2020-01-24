package com.udemy.app.ws.service.impl;

import java.io.PrintStream;
import java.util.ArrayList;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.udemy.app.ws.io.entity.UserEntity;
import com.udemy.app.ws.io.repository.UserRepository;
import com.udemy.app.ws.service.UserService;
import com.udemy.app.ws.shared.Utils;
import com.udemy.app.ws.shared.dto.UserDto;


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
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
	
		UserEntity storedEntity = userRepository.findByEmail(email);
		
		if(storedEntity==null) {
			throw new UsernameNotFoundException("Invalid username => "+email);
		}
		
		return new User(storedEntity.getEmail(),storedEntity.getEncryptedPassword(),new ArrayList<>());
	}
	
	@Override
	public UserDto getUser(String email) {
		
		UserEntity userEntity = userRepository.findByEmail(email);
		
		if(userEntity==null) {
			throw new UsernameNotFoundException(email);
		}
		
		UserDto returnValue = new UserDto();
		BeanUtils.copyProperties(userEntity, returnValue);
		
		return returnValue;
	}

	@Override
	public UserDto getUserByUserId(String id) {
		
		UserEntity userEntity = userRepository.findByUserId(id);
		
		if(userEntity==null) {
			throw new UsernameNotFoundException(id);
		}
		
		UserDto userDto = new UserDto();
		BeanUtils.copyProperties(userEntity, userDto);
		
		return userDto;
		
	}

}
