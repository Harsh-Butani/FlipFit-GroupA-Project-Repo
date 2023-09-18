package com.flipkart.exception;

public class AlreadyRegisteredException extends Exception {
	private String email;
	private String role;
	
	public AlreadyRegisteredException(String email, String role) {
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
