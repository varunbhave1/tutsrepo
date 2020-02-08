package com.udemy.app.ws.shared;

import java.security.SecureRandom;
import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class Utils {
	
	private final Random RANDOM = new SecureRandom();
	private final String ALPHABETNUMERIC = "0123456789ABCDEFJHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	private final int ITERATIONS = 10000;
	private final int KEY_LENGTH = 256;
	private final String USER_ID_PREFIX = "USR-";
	private final String ADDRESS_ID_PREFIX = "ADR-";
	
	/**
	 * @param length
	 * @return
	 */
	public String generateUserId(int length) {
	
		return generateRandomString(USER_ID_PREFIX,length);
		
	}
	
	public String generateAddressId(int length) {
		
		return generateRandomString(ADDRESS_ID_PREFIX,length);
		
	}
	
	
	/**
	 * @param length
	 * @return
	 */
	private String generateRandomString(final String PREFIX, int length) {
		
		StringBuilder returnValue = new StringBuilder(length);
		
		for(int i=0;i<length;i++) {
			returnValue.append(ALPHABETNUMERIC.charAt(RANDOM.nextInt(ALPHABETNUMERIC.length())));
		}
		
		return PREFIX+returnValue.toString();
	}
	

}
