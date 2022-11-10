package com.cloth.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

public class ProductAttributedto {
	@Positive(message = "Id should be greater than Zero")
	private int productId;
	
	private int attributeId;
	@NotBlank(message = "Attribute name can not be null")
	private String attributeName;
	@NotBlank(message = "Size can not be null")
	private String size;
	
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getAttributeId() {
		return attributeId;
	}
	public void setAttributeId(int attributeId) {
		this.attributeId = attributeId;
	}
	
	public String getAttributeName() {
		return attributeName;
	}
	public void setAttributeName(String attributeName) {
		this.attributeName = attributeName;
	}
	/**
	 * @return the size
	 */
	public String getSize() {
		return size;
	}
	/**
	 * @param size the size to set
	 */
	public void setSize(String size) {
		this.size = size;
	}
	

}
