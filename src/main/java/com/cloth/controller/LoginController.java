package com.cloth.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cloth.dto.LoginCredentials;
import com.cloth.entity.Category;
import com.cloth.entity.UserCredentials;
import com.cloth.service.CategoryService;
import com.cloth.service.LoginService;

@RestController
@RequestMapping("/cloths")
public class LoginController {
	@Autowired
	private LoginService loginService;
	@Autowired
	private CategoryService categoryService;
	@PostMapping("/signup")
	public ResponseEntity<String> signUp(@Valid @RequestBody UserCredentials user) {
		return ResponseEntity.ok().body(loginService.signUp(user));
		
	}
	
	@PostMapping("/login")
	public  ResponseEntity<?> login(@Valid @RequestBody LoginCredentials log) {
		List<Category> list=new ArrayList<>();
		if(loginService.login(log)==true) {
		list=categoryService.getAllCategory();
		return ResponseEntity.ok().body(list);
		}
		else {
		return ResponseEntity.ok().body("Wrong credentials.");
		}
	}
	@DeleteMapping("/{id}")
	public void deleteUserCredential(@PathVariable int id) {
		loginService.deleteById(id);
	}
}
