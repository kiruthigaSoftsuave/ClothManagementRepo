package com.cloth.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.cloth.dto.LoginCredentials;
import com.cloth.entity.UserCredentials;
import com.cloth.repository.UserCredentialsRepository;

@Service
public class LoginService {
	@Autowired
	private UserCredentialsRepository userCredentialsRepository;

	public String signUp(UserCredentials user) {

		String s="";
		if(userCredentialsRepository.findByEmail(user.getEmail())==null) {
	
				//return ResponseEntity.ok().body("User is already registered. Please do login.");
			if (user.getPassword().equals(user.getConfirmPassword())) {
				userCredentialsRepository.save(user);
			} else {
				s="password and confirm Password are not same";
				//System.out.println("password and confirm Password are not same");
			}
		}
		else {
		   s="User is already registered. Please do login.";
		}
		return s;
	}

	public boolean login(LoginCredentials log) {
		boolean flag=false;
		UserCredentials u = userCredentialsRepository.findByEmailAndPassword(log.getEmail(), log.getPassword());
		if(u!=null) {
			return true;
		}
		return flag;
	}

	public void deleteById(int id) {
		// TODO Auto-generated method stub
		if (userCredentialsRepository.existsById(id)) {
			userCredentialsRepository.deleteById(id);
		}

	}

}
