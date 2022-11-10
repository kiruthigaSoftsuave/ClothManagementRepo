package com.cloth.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloth.dto.Attribute;
import com.cloth.dto.CategoryProduct;
import com.cloth.dto.CategoryResponse;
import com.cloth.entity.Category;
import com.cloth.entity.Product;
import com.cloth.entity.ProductAttribute;
import com.cloth.repository.CategoryRepository;
import com.cloth.repository.ProductAttributeRepository;
import com.cloth.repository.ProductRepository;
@Service
public class CategoryService {
	@Autowired
	private CategoryRepository catRepository;
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private ProductAttributeRepository productAttributeRepository;
	
	public void save(Category cat) {
		catRepository.save(cat);
	}
    public void deleteById(int id) {
    	List<Product> products=productRepository.findAll();
    	for(Product p:products) {
        	if(p.getCategory().getId()==id) {
        		int id1=p.getId();
        		List<Attribute> attributes=new ArrayList<>();
        		for(ProductAttribute productAttribute:p.getProdAttribute()) {
        			if(productAttribute.getProduct().getId()==id1) {
        				productAttributeRepository.deleteById(productAttribute.getId());
        			}
        		}
        		productRepository.deleteById(id1);
        	}
    	}
    	catRepository.deleteById(id);
    	System.out.println("category deleted completely");
    }
    public void deleteAll() {
    	productAttributeRepository.deleteAll();
    	
    	productRepository.deleteAll();
    	catRepository.deleteAll();
    }
    public CategoryResponse getCategory(int categoryId) {
    	CategoryResponse categoryResponse=new CategoryResponse();
    	categoryResponse.setCategoryId(categoryId);
    	Category category=catRepository.findById(categoryId).get();
    	categoryResponse.setGender(category.getGender());
    	List<Product> products=productRepository.findAll();
        List<CategoryProduct> categoryProducts=new ArrayList<>();
        for(Product p:products) {
        	if(p.getCategory().getId()==categoryId) {
        		CategoryProduct categoryProduct=new CategoryProduct();
        		categoryProduct.setProductId(p.getId());
        		categoryProduct.setProductName(p.getName());
        		List<Attribute> attributes=new ArrayList<>();
        		for(ProductAttribute productAttribute:p.getProdAttribute()) {
        			Attribute a=new Attribute();
        			a.setAttributeId(productAttribute.getId());
        			a.setAttributeName(productAttribute.getValue());
        			attributes.add(a);
        		}
        		
        		categoryProducts.add(categoryProduct);
        		categoryProduct.setAttributes(attributes);
            }
        }
        categoryResponse.setProducts(categoryProducts);
    	return categoryResponse;
    }
	public List<Category> getAllCategory() {
		// TODO Auto-generated method stub
		List<Category> list=catRepository.findAll();
		return list;
	}	
    
    

}
