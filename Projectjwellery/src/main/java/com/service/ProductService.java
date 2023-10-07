package com.service;

import java.util.List;
import java.util.Optional;

 

import com.entity.Category;
import com.entity.Product;

 

public interface ProductService {

	public List<Product> getAllProduct();
    public Optional<Product> getProductById(int productId);
    public List<Product> getProductByCategory(Category category);
    public Product createProduct(Product product);
    public Product updateProduct(int productId, Product updatedProduct); 
    public void deleteProduct(int productId);
	
}