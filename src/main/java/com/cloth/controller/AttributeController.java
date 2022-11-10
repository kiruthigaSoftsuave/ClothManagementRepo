package com.cloth.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cloth.dto.AttributeResponse;
import com.cloth.dto.ProductAttributedto;
import com.cloth.entity.ProductAttribute;
import com.cloth.service.AttributeService;

import com.cloth.validation.CommonValidation;

@RestController
@RequestMapping("/attribute")
public class AttributeController {
	@Autowired
	private AttributeService attributeService;
	@Autowired
	private CommonValidation commonValidation;

	@PostMapping
	public ResponseEntity<ProductAttributedto> saveAttribute(@Valid @RequestBody ProductAttributedto attributeDto) {
		ProductAttributedto r=new ProductAttributedto();
		if(commonValidation.validateOnlyAlphabet(attributeDto.getAttributeName())) {
			
		r=attributeService.saveAttribute(attributeDto);
		}
		else {
			System.out.println("please enter valid attribute name");
		}
		return ResponseEntity.ok().body(r);
	}
	@GetMapping("/{id}")
	public ResponseEntity<AttributeResponse> getAttributeResponse(@PathVariable int id) {
		AttributeResponse r=attributeService.getAttributeResponse(id);
		return ResponseEntity.ok().body(r);
		
	}
	@GetMapping
    public ResponseEntity<List<AttributeResponse>> getAllProductAttribute() {
		
		List<AttributeResponse> list=attributeService.getAllProductAttribute();
		
		return ResponseEntity.ok().body(list);
		
	}
		
	@DeleteMapping("/{id}")
	public ResponseEntity<String> daleteAttribute(@PathVariable int id) {
		attributeService.daleteAttribute(id);
		return new ResponseEntity<String>("Attribute deleted successfully!.", HttpStatus.OK);
	}
	@DeleteMapping
	public ResponseEntity<String> deleteAllAttribute() {
		attributeService.deleteAllAttribute();
		
		return new ResponseEntity<String>("All attributes deleted successfully!.", HttpStatus.OK);
	}

}
