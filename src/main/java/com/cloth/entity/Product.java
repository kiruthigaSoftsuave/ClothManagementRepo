package com.cloth.entity;

import java.util.List;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

@Entity
@Table
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private int id;
	
	@Column(name = "name")
	@NotBlank(message = "Product name cannot be blank")
	@Length(min = 1, max = 25, message="Please give valid name")
	private String name;
	
	@ManyToOne
	@Valid
	private Category category;

    @OneToMany(cascade = CascadeType.MERGE, mappedBy = "product")
    @Valid
	private List<ProductAttribute> prodAttribute;
	
    public Product(int id, String name, Category category, List<ProductAttribute> prodAttribute) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
		
		this.prodAttribute = prodAttribute;
	}
    
    

	public Product() {
		
	}

	public int getId() {
		return id;
	}

	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public List<ProductAttribute> getProdAttribute() {
		return prodAttribute;
	}

	public void setProdAttribute(List<ProductAttribute> prodAttribute) {
		this.prodAttribute = prodAttribute;
	}



	public void setId(int id) {
		this.id = id;
	}



	
	
}
