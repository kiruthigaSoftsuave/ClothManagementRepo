package com.cloth.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table
public class ProductAttribute {
	@Id
	@GeneratedValue
	private int id;
	@NotBlank(message = "Attribute name cannot be null")
	private String value;
	private String size;
	
	public ProductAttribute(String value, Product product, String size) {
		super();
	
		this.value = value;
		this.product = product;
		this.size=size;
	}

	@ManyToOne(cascade = CascadeType.MERGE, targetEntity = Product.class)
	@JoinColumn(name = "product_id" )
	private Product product;
	
	public ProductAttribute() {
		
	}

	public int getId() {
		return id;
	}
   
	

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	
	public String getSize() {
		return size;
	}
	
	public void setSize(String size) {
		this.size = size;
	}

	
	
}
