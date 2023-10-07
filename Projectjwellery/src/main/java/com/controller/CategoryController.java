package com.controller;


import java.util.List;

 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.entity.Category;
import com.service.CategoryService;

 

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

 

    @Autowired
    private CategoryService categoryService;

 

    @GetMapping
    public ResponseEntity<List<Category>> getAllCategories() {
        List<Category> categories = categoryService.getAllCategories();
        return ResponseEntity.ok(categories);
    }

 

    @GetMapping("/{categoryId}")
    public ResponseEntity<Category> getCategoryById(@PathVariable int categoryId) {
        try {
            Category category = categoryService.getCategoryById(categoryId);
            return ResponseEntity.ok(category);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

 

    @PostMapping("/createcategory")
    public ResponseEntity<Category> createCategory(@RequestBody Category category) {
        Category createdCategory = categoryService.createCategory(category);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCategory);
    }

 

    @PutMapping("/{categoryId}")
    public ResponseEntity<Category> updateCategory(@PathVariable int categoryId, @RequestBody Category updatedCategory) {
        try {
            Category updated = categoryService.updateCategory(categoryId, updatedCategory);
            return ResponseEntity.ok(updated);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

 

    @DeleteMapping("/{categoryId}")
    public ResponseEntity<Void> deleteCategory(@PathVariable int categoryId) {
        try {
            categoryService.deleteCategory(categoryId);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}


