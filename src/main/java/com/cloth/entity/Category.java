package com.cloth.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table
public class Category {
	@Id
	@GeneratedValue
	
	private int id;

	@Column(name = "gender")
	@NotBlank(message = "Please enter category")
	private String gender;
	
	
	
	public Category(int id, String gender) {
		super();
		this.id = id;
		this.gender = gender;
//		this.products = products;
	}

	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
}
