/**
 * 
 */
package com.udemy.app.ws.io.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.udemy.app.ws.io.entity.UserEntity;

/**
 * @author VBHAVE
 *
 */

@Repository
public interface UserRepository extends PagingAndSortingRepository<UserEntity, Long> {

	//all the basic CRUD operations are provided by CrudRepository
	
	//custom operations can be provided here.
	
	UserEntity findByEmail(String email);

	UserEntity findByUserId(String userId);

	
}
