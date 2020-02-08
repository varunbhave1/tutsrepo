package com.udemy.app.ws.ui.controller;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.udemy.app.ws.service.UserService;
import com.udemy.app.ws.shared.dto.UserDto;
import com.udemy.app.ws.ui.model.request.UserDetailsRequestModel;
import com.udemy.app.ws.ui.model.response.OperationStatusModel;
import com.udemy.app.ws.ui.model.response.RequestOperationName;
import com.udemy.app.ws.ui.model.response.RequestOperationStatus;
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
	
	//respond to HTTP GET request coming for request mapping : /users
	@GetMapping(path="/{id}",
			produces = {MediaType.APPLICATION_JSON_VALUE, 
					MediaType.APPLICATION_XML_VALUE}
			)  
	public UserRest getUser(@PathVariable String id) {
		
		UserRest userRest = new UserRest();
		UserDto userDto = userService.getUserByUserId(id);
		BeanUtils.copyProperties(userDto, userRest);
		return userRest;
	}
	
	//respond to HTTP POST request coming for request mapping : /users
	@PostMapping(
			produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE},
			consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})  
	public UserRest createUser(@RequestBody UserDetailsRequestModel userDetailsModel) throws Exception {
		
		UserRest userResponseVal = new UserRest();
		
		/*if(userDetailsModel.getEmail().isEmpty()) {
			throw new UserServiceException(ErrorMessages.MISSING_REQUIRED_FIELD.getErrorMessage());
		}*/
		
		//Using modelMapper instead of BeanUtils.copyProperties
		//UserDto userDto = new UserDto();
		//BeanUtils.copyProperties(userDetailsModel, userDto);
		ModelMapper modelMapper = new ModelMapper();
		UserDto userDto = modelMapper.map(userDetailsModel, UserDto.class);
		
		UserDto createdUser =  userService.createUser(userDto);
		//BeanUtils.copyProperties(createdUser, userResponseVal);
		userResponseVal = modelMapper.map(createdUser, UserRest.class);
		return userResponseVal;
	}
	
	//respond to HTTP PUT request coming for request mapping : /users
	@PutMapping(path = "/{id}",
			produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE},
			consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})  
	public UserRest updateUser(@PathVariable String id,@RequestBody UserDetailsRequestModel userDetails) {
		
		UserRest userResponseVal = new UserRest();
		
		UserDto userDto = new UserDto();
		BeanUtils.copyProperties(userDetails, userDto);
		UserDto updatedUser = userService.updateUser(id, userDto);
		BeanUtils.copyProperties(updatedUser, userResponseVal);
		return userResponseVal;
	}
	
	//respond to HTTP DELETE request coming for request mapping : /users
	@DeleteMapping(path="/{id}",
			produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})   
	public OperationStatusModel deleteUser(@PathVariable String id) {
		
		OperationStatusModel returnValue = new OperationStatusModel();
		returnValue.setOperationName(RequestOperationName.DELETE.name());
		returnValue.setOperationResult(RequestOperationStatus.SUCCESS.name());
		
		userService.deleteUserById(id);
		return returnValue;
		
	}
	
	@GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public List<UserRest> getUsers(@RequestParam(value="page", defaultValue = "0")int page,
			@RequestParam(value="limit",defaultValue ="25")int limit){
		
		List<UserRest> returnValue = new ArrayList<>();
		
		List<UserDto> users = userService.getUsers(page,limit);
		
		for(UserDto userDto:users) {
			UserRest currUser = new UserRest();
			BeanUtils.copyProperties(userDto, currUser);
			returnValue.add(currUser);
		}
		
		return returnValue;
		
	} 
	
}
