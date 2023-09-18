/**
 * 
 */
package com.flipkart.exception;

/**
 * 
 */
public class WrongEmailFormatException extends Exception{
	private String email;
	public WrongEmailFormatException(String email) {
		this.email = email;
	}
	
	public String getEmail() {
		return email;
	}
}
