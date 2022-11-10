package com.cloth.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloth.dto.Attribute;
import com.cloth.dto.ProductResponse;
import com.cloth.entity.Category;
import com.cloth.entity.Product;
import com.cloth.entity.ProductAttribute;
import com.cloth.repository.CategoryRepository;
import com.cloth.repository.ProductAttributeRepository;
import com.cloth.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private ProductAttributeRepository productAttributeRepository;

	public Optional<Category> getCategoryNameById(int id) {
		Optional<Category> c = categoryRepository.findById(id);
		return c;

	}

	public ProductResponse saveProduct(Product p) {
		ProductResponse response = new ProductResponse();
		Product product = productRepository.save(p);
		for (ProductAttribute pa : p.getProdAttribute()) {
			pa.setProduct(p);
			productAttributeRepository.save(pa);
		}
		response.setCategoryId(product.getCategory().getId());
		response.setGender(product.getCategory().getGender());
		response.setProductId(product.getId());
		response.setProductName(product.getName());
		List<Attribute> attributes = new ArrayList<>();
		for (ProductAttribute att : product.getProdAttribute()) {
			Attribute a = new Attribute();
			a.setAttributeId(att.getId());
			a.setAttributeName(att.getValue());
			a.setAttributeSize(att.getSize());
			attributes.add(a);
		}
		response.setAttribute(attributes);
		return response;

	}

  

	public ProductResponse getProductById(int productId) {
		ProductResponse response = new ProductResponse();
		if (productRepository.existsById(productId)) {
			Product product=productRepository.findById(productId).get();
			response.setProductId(productId);
			response.setCategoryId(product.getCategory().getId());
			response.setGender(product.getCategory().getGender());
			response.setProductName(product.getName());
			List<Attribute> attributes = new ArrayList<>();
			List<ProductAttribute> prodAttributes=productAttributeRepository.findByProductId(productId);
			for(ProductAttribute att:prodAttributes) {
				Attribute a = new Attribute();
				a.setAttributeId(att.getId());
				a.setAttributeName(att.getValue());
				a.setAttributeSize(att.getSize());
				attributes.add(a);
			}
			response.setAttribute(attributes);
		}
		return response;

	}

	public void deleteById(int id) {
		if (productRepository.existsById(id)) {

			Product product = productRepository.findById(id).get();
			product.setCategory(null);
			List<ProductAttribute> attributes = productAttributeRepository.findAll();
			for (ProductAttribute p : attributes) {
				if (p.getProduct().getId() == id) {
					p.setProduct(null);
					productAttributeRepository.delete(p);
				}
			}
			product.setProdAttribute(null);
			productRepository.delete(product);
		}
	}

	public void deleteAll() {
		productRepository.deleteAll();
	}

	public List<ProductResponse> getAllProducts() {
//		return productRepository.findAll();	

		List<Product> list = productRepository.findAll();
		List<ProductResponse> pr = new ArrayList<>();
		for (Product p : list) {
			ProductResponse response = new ProductResponse();
			response.setCategoryId(p.getCategory().getId());
			response.setGender(p.getCategory().getGender());
			response.setProductId(p.getId());
			response.setProductName(p.getName());
			List<Attribute> attributes = new ArrayList<>();
			List<ProductAttribute> productAttributes = p.getProdAttribute();
			if (productAttributes != null) {
				for (ProductAttribute productAttribute : p.getProdAttribute()) {
					Attribute curAttribute = new Attribute();
					curAttribute.setAttributeName(productAttribute.getValue());
					curAttribute.setAttributeId(productAttribute.getId());
					curAttribute.setAttributeSize(productAttribute.getSize());
					attributes.add(curAttribute);
				}

			}
			response.setAttribute(attributes);
			pr.add(response);
		}
		return pr;
	}

}
