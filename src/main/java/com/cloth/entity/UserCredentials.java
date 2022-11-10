package com.cloth.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
@Table
public class UserCredentials {
	@Id
	@GeneratedValue
	private int id;
	@NotBlank(message = "username cannot bu null")
	private String username;
	@Email(message = "Please enter a valid email")
	private String email;
	@NotBlank(message = "Password cannot bu null")
	private String password;
	@NotBlank(message = "Password cannot bu null")
	private String confirmPassword;
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	
	
	public UserCredentials(@NotBlank(message = "username cannot bu null") String username,
			@Email(message = "Please enter a valid email") String email,
			@NotBlank(message = "Password cannot bu null") String password,
			@NotBlank(message = "Password cannot bu null") String confirmPassword) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
		this.confirmPassword = confirmPassword;
	}
	public UserCredentials() {
		
	}

	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
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
	/**
	 * @return the confirmPassword
	 */
	public String getConfirmPassword() {
		return confirmPassword;
	}
	/**
	 * @param confirmPassword the confirmPassword to set
	 */
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

}
