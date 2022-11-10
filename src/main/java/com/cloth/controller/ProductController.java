package com.cloth.controller;


import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cloth.dto.ProductResponse;
import com.cloth.entity.Product;
import com.cloth.service.ProductService;
import com.cloth.validation.CommonValidation;

@RestController
@RequestMapping("/product")
public class ProductController {
	@Autowired
	private ProductService productService;
	@Autowired
	
	private CommonValidation commonValidation;
	
	@PostMapping
    public ResponseEntity<ProductResponse> saveProduct(@RequestBody @Valid Product p) {
		ProductResponse response=new ProductResponse();
		if(commonValidation.validateOnlyAlphabet(p.getName())) {
    	response=productService.saveProduct(p);
		}
		else {
			System.out.println("please enter valid product name");
		}
		return ResponseEntity.ok().body(response);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteById(@PathVariable int id) {
		productService.deleteById(id);
		return new ResponseEntity<String>("Product deleted successfully!.", HttpStatus.OK);
	}
	@DeleteMapping
	public ResponseEntity<String> deleteAll() {
		productService.deleteAll();
		return new ResponseEntity<String>("All Products deleted successfully!.", HttpStatus.OK);
	}
	@GetMapping
	public ResponseEntity<List<ProductResponse>> getAllProducts() {
		List<ProductResponse> list= productService.getAllProducts();
		HttpHeaders headers=new HttpHeaders();
		headers.add("Token", "Token value");
		return ResponseEntity.ok().headers(headers).body(list);
		
	}

	@GetMapping("/{id}")
	public ResponseEntity<ProductResponse> getById(@PathVariable(value = "id") int id) {
		
		return ResponseEntity.ok().body(productService.getProductById(id));
	}
}