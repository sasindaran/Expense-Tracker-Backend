package com.Projectalpha.ExpenseTrackerApplication.Controller;

import com.Projectalpha.ExpenseTrackerApplication.entity.Category;
import com.Projectalpha.ExpenseTrackerApplication.service.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public List<Category> getCategories() {
        return categoryService.getAllCategories();
    }
}