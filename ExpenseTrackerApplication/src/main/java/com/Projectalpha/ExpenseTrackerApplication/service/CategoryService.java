package com.Projectalpha.ExpenseTrackerApplication.service;

import com.Projectalpha.ExpenseTrackerApplication.entity.Category;
import com.Projectalpha.ExpenseTrackerApplication.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }
}
