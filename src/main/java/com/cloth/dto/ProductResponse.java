package com.cloth.dto;

import java.util.List;

import com.cloth.entity.Category;
import com.cloth.entity.Product;
import com.cloth.entity.ProductAttribute;

public class ProductResponse {
	
    private int productId;
    private String productName;
    private int categoryId;
    private String gender;
    private List<Attribute> attribute;
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
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
	public List<Attribute> getAttribute() {
		return attribute;
	}
	public void setAttribute(List<Attribute> attribute) {
		this.attribute = attribute;
	}
}
