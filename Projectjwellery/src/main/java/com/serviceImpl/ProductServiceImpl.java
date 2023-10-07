package com.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

 

import com.entity.Category;
import com.entity.Product;
import com.repository.ProductRepository;
import com.service.ProductService;

 

@Service
public class ProductServiceImpl implements ProductService{
@Autowired
	ProductRepository prorepo;

 

	@Override
	public List<Product> getAllProduct() {
		return prorepo.findAll();
	}

 

	@Override
	public Optional<Product> getProductById(int productId) {
		return prorepo.findById(productId);
	}

 

	@Override
	public List<Product> getProductByCategory(Category category) {
		 return prorepo.findByCategory(category);
	}

 

	@Override
	public Product createProduct(Product product) {
		 return prorepo.save(product);

	}

 

	@Override
	public Product updateProduct(int productId, Product updatedProduct) {
		 if (!prorepo.existsById(productId)) {
	            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Food Item not found");
	        }
	        updatedProduct.setProductId(productId);
	        return prorepo.save(updatedProduct);
	}

 

	@Override
	public void deleteProduct(int productId) {
		prorepo.deleteById(productId);

	}

 

	

 

}