package com.cloth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cloth.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer>{
	

}
