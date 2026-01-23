package com.Projectalpha.ExpenseTrackerApplication.repository;

import com.Projectalpha.ExpenseTrackerApplication.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
