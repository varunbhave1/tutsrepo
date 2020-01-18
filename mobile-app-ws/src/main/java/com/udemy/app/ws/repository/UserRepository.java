/**
 * 
 */
package com.udemy.app.ws.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.udemy.app.ws.io.entity.UserEntity;

/**
 * @author VBHAVE
 *
 */

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {

	//all the basic CRUD operations are provided by CrudRepository
	
	//custom operations can be provided here.
	
	UserEntity findByEmail(String email);

	
}
