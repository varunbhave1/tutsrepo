package com.udemy.app.ws.ui.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.udemy.app.ws.service.UserService;
import com.udemy.app.ws.shared.dto.UserDto;
import com.udemy.app.ws.ui.model.request.UserDetailsRequestModel;
import com.udemy.app.ws.ui.model.response.UserRest;

/*
 * Annotations Used : 
 * 
 * @RequestBody => Indicates a method parameter should be bound to the body of the web request 
 * 				   ( request body is passed through  HttpMessageConvertor for argument resolution)
 * 
 * @<HTTP REQUEST TYPE>Mapping : Annotations for mapping the HTTP methods to corresponding handler method. 
 * 
 * */

@RestController
@RequestMapping("users") //http:localhost:8080/users
public class UserController {

	@Autowired
	UserService userService;
	
	@GetMapping  //respond to HTTP GET request coming for request mapping : /users
	public String getUser() {
		return "getUser() was called !";
	}
	
	@PostMapping  //respond to HTTP POST request coming for request mapping : /users
	public UserRest createUser(@RequestBody UserDetailsRequestModel userDetailsModel) {
		
		UserRest userResponseVal = new UserRest();
		UserDto userDto = new UserDto();
		
		BeanUtils.copyProperties(userDetailsModel, userDto);
		
		UserDto createdUser =  userService.createUser(userDto);
		
		BeanUtils.copyProperties(createdUser, userResponseVal);
		
		return userResponseVal;
	}
	
	@PutMapping  //respond to HTTP PUT request coming for request mapping : /users
	public String updateUser() {
		
		return "updateUser() was called !";
	}
	
	@DeleteMapping   //respond to HTTP DELETE request coming for request mapping : /users
	public String deleteUser() {
		return "deleteUser() was called !";
	}
}
