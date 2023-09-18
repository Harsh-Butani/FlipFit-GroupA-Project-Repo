package com.flipkart.exception;

/**
 * @author kshitij.gupta1
 */
public class UserNotRegisteredException extends Exception {
	private String email;
	private String role;
	
	public UserNotRegisteredException(String email, String role) {
		this.email = email;
		this.role = role;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getRole() {
		return role;
	}
}
