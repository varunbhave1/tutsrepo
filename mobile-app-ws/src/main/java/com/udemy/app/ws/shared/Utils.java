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
	
	/**
	 * @param length
	 * @return
	 */
	public String generateUserId(int length) {
	
		return generateRandomString(length);
		
	}
	
	
	/**
	 * @param length
	 * @return
	 */
	private String generateRandomString(int length) {
		
		StringBuilder returnValue = new StringBuilder(length);
		
		for(int i=0;i<length;i++) {
			returnValue.append(ALPHABETNUMERIC.charAt(RANDOM.nextInt(ALPHABETNUMERIC.length())));
		}
		
		return returnValue.toString();
	}
	

}
