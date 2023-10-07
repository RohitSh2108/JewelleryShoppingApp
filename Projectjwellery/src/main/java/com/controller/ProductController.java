package com.controller;
import java.util.List;
import java.util.Optional;

 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.entity.Product;
import com.service.ProductService;

 

@RestController
@RequestMapping("/api/product")
public class ProductController {

 

    @Autowired
    private ProductService productService;

 

    @GetMapping("/getproduct")
    public ResponseEntity<List<Product>> getAllProduct() {
        List<Product> products = productService.getAllProduct();
        return ResponseEntity.ok(products);
    }

 

    @GetMapping("/getProductById/{productId}")
    public ResponseEntity<Product> getProductById(@PathVariable int productId) {
        Optional<Product> product = productService.getProductById(productId);
        if (product.isPresent()) {
            return ResponseEntity.ok(product.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

 

    @PostMapping("/createproduct")
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        Product createdProduct = productService.createProduct(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdProduct);
    }

 

    @PutMapping("/{productId}")
    public ResponseEntity<Product> updateProduct(@PathVariable int productId, @RequestBody Product updatedProduct) {
        Product updated = productService.updateProduct(productId, updatedProduct);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

 

    @DeleteMapping("/{productId}")
    public ResponseEntity<Void> deleteProduct(@PathVariable int productId) {
        productService.deleteProduct(productId);
        return ResponseEntity.noContent().build();
    }
}


