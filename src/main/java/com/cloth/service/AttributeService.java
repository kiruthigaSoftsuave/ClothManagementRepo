package com.cloth.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cloth.dto.Attribute;
import com.cloth.dto.AttributeResponse;
import com.cloth.dto.ProductAttributedto;
import com.cloth.entity.Product;
import com.cloth.entity.ProductAttribute;
import com.cloth.repository.ProductAttributeRepository;
import com.cloth.repository.ProductRepository;

@Service
public class AttributeService {
	@Autowired
	private ProductAttributeRepository attributeRepository;
	@Autowired
	private ProductRepository productRepository;
	
	public ProductAttributedto saveAttribute(ProductAttributedto attributeDto) {
	    Product p=productRepository.findById(attributeDto.getProductId()).get();
	    ProductAttribute pa=new ProductAttribute();
	   
	    pa.setValue(attributeDto.getAttributeName());
	    pa.setSize(attributeDto.getSize());
	    pa.setProduct(p);
	    attributeRepository.save(pa);
		return attributeDto;
	}
	public List<ProductAttribute> findbyProductId(int id) {
		return attributeRepository.findByProductId(id);
		
	}
	
	public AttributeResponse getAttributeResponse(int attributeId) {
		AttributeResponse response=new AttributeResponse();
		if(attributeRepository.existsById(attributeId)) {
		ProductAttribute attribute=attributeRepository.findById(attributeId).get();
		response.setAttributeId(attribute.getId());
		response.setAttributeName(attribute.getValue());
		response.setProductId(attribute.getProduct().getId());
		response.setAttributeSize(attribute.getSize());
		response.setProductName(attribute.getProduct().getName());
		}
		return response;
		
	}
	
    public List<AttributeResponse> getAllProductAttribute() {
		
    	List<ProductAttribute> list=attributeRepository.findAll();
    	List<AttributeResponse> responseList=new ArrayList<>();
    	for(ProductAttribute attribute:list) {
    		AttributeResponse response=new AttributeResponse();
    		response.setAttributeId(attribute.getId());
    		response.setAttributeName(attribute.getValue());
    		response.setProductId(attribute.getProduct().getId());
    		response.setProductName(attribute.getProduct().getName());
    		response.setAttributeSize(attribute.getSize());
    		responseList.add(response);
    	}
		return responseList;
		
	}
	public void daleteAttribute(int atributeId) {
		if(attributeRepository.existsById(atributeId)) {
		    ProductAttribute a= attributeRepository.findById(atributeId).get();
		    a.setProduct(null);
		    
		    attributeRepository.delete(a);
		    
		}
	}	
	public void deleteAllAttribute() {
		List<ProductAttribute> attributes=attributeRepository.findAll();
		for(ProductAttribute p: attributes) {
			p.setProduct(null);
		}
		attributeRepository.deleteAll();
		
	}

}
