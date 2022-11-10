package com.cloth.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cloth.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{
	
}
