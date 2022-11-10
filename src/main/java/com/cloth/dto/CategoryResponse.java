package com.cloth.dto;

import java.util.List;

import com.cloth.entity.Product;


public class CategoryResponse {
	
	private int categoryId;
	
	private String gender;
	
	private List<CategoryProduct> products;

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public List<CategoryProduct> getProducts() {
		return products;
	}

	public void setProducts(List<CategoryProduct> products) {
		this.products = products;
	}

}
