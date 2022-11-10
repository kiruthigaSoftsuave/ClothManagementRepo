package com.cloth.dto;

public class AttributeResponse {
	private int attributeId;
	private String attributeName;
	private String attributeSize;
	private int ProductId;
	private String ProductName;
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
	 * @return the productId
	 */
	public int getProductId() {
		return ProductId;
	}
	/**
	 * @param productId the productId to set
	 */
	public void setProductId(int productId) {
		ProductId = productId;
	}
	/**
	 * @return the productName
	 */
	public String getProductName() {
		return ProductName;
	}
	/**
	 * @param productName the productName to set
	 */
	public void setProductName(String productName) {
		ProductName = productName;
	}
	/**
	 * @return the attributeSize
	 */
	public String getAttributeSize() {
		return attributeSize;
	}
	/**
	 * @param attributeSize the attributeSize to set
	 */
	public void setAttributeSize(String attributeSize) {
		this.attributeSize = attributeSize;
	}

}