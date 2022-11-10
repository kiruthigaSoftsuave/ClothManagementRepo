package com.cloth.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cloth.dto.CategoryResponse;
import com.cloth.entity.Category;

import com.cloth.service.CategoryService;
import com.cloth.validation.CommonValidation;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
	private CategoryService catService;
    @Autowired
    private CommonValidation commonValidation;
	
	@PostMapping
	public ResponseEntity<Category> saveCategory(@Valid @RequestBody Category category) {
		if(commonValidation.validateOnlyAlphabet(category.getGender())) {
	    catService.save(category);
		System.out.println("Category saved");
		}
		else {
			System.out.println("please enter valid category name");
		}
		return ResponseEntity.ok().body(category);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteCategory(@PathVariable int id) {
		catService.deleteById(id);
		return new ResponseEntity<String>("Ctegory deleted successfully!.", HttpStatus.OK);
	}
	@DeleteMapping
	public ResponseEntity<String> deleteAll() {
		catService.deleteAll();
		return new ResponseEntity<String>("All categories deleted successfully!.", HttpStatus.OK);
	}
	@GetMapping("/{id}")
	public ResponseEntity<CategoryResponse> getCateory(@PathVariable int id) {
		CategoryResponse c=catService.getCategory(id);
		return ResponseEntity.ok().body(c);
	}
	@GetMapping
	public ResponseEntity<List<Category>> getAllCategory(){
		List<Category> c=catService.getAllCategory();
		HttpHeaders headers=new HttpHeaders();
		headers.add("token", "token value");
		return ResponseEntity.ok().headers(headers).body(c);
	}

}
