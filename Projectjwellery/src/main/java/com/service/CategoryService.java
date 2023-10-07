package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Category;
import com.repository.CategoryRepository;

public interface CategoryService {

   
    public List<Category> getAllCategories() ;
    public Category getCategoryById(int categoryId) ;
    public Category createCategory(Category category) ;
    public Category updateCategory(int categoryId, Category updatedCategory) throws Exception ;
    public void deleteCategory(int categoryId) throws Exception ;
      
}
