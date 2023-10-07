package com.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Category;
import com.repository.CategoryRepository;
import com.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getCategoryById(int categoryId) {
        return categoryRepository.findById(categoryId).orElse(null);
    }

    @Override
    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category updateCategory(int categoryId, Category updatedCategory) throws Exception {
        if (!categoryRepository.existsById(categoryId)) {
            // Handle not found
            throw new Exception("Category not found with id: " + categoryId);
        }
        updatedCategory.setId(categoryId);
        return categoryRepository.save(updatedCategory);
    }

    @Override
    public void deleteCategory(int categoryId) throws Exception {
        if (!categoryRepository.existsById(categoryId)) {
            // Handle not found
            throw new Exception("Category not found with id: " + categoryId);
        }
        categoryRepository.deleteById(categoryId);
    }

	
}
