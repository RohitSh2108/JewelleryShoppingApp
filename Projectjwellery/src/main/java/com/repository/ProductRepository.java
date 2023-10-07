package com.repository;

import java.util.List;



import org.springframework.data.jpa.repository.JpaRepository;

 

import com.entity.Category;
import com.entity.Product;

 

public interface ProductRepository extends JpaRepository<Product, Integer> {

	List<Product> findByCategory(Category category);

 

//	List<Product> findByCategory(Category category);

 

}
