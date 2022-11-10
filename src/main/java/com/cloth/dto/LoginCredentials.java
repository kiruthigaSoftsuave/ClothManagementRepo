package com.cloth.dto;

import javax.validation.constraints.NotBlank;

public class LoginCredentials {
	@NotBlank(message = "Please enter the email")
	private String email;
	@NotBlank(message = "Please enter the password")
	private String password;
	/**
	 * @return the email
	 */
	public LoginCredentials() {
		
	}
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	public LoginCredentials(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

}
