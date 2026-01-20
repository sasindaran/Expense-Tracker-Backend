package com.Projectalpha.ExpenseTrackerApplication.service;

import com.Projectalpha.ExpenseTrackerApplication.entity.Expense;
import com.Projectalpha.ExpenseTrackerApplication.entity.User;
import com.Projectalpha.ExpenseTrackerApplication.repository.ExpenseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseService {

    private final ExpenseRepository expenseRepository;

    public ExpenseService(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    public Expense addExpense(Expense expense) {
        return expenseRepository.save(expense);
    }

    public List<Expense> getExpensesByUser(User user) {
        return expenseRepository.findByUser(user);
    }

    public void deleteExpense(Long expenseId, User user) {

        Expense expense = expenseRepository
                .findByIdAndUser(expenseId, user)
                .orElseThrow(() ->
                        new RuntimeException("Expense not found or access denied")
                );

        expenseRepository.delete(expense);
    }
}
