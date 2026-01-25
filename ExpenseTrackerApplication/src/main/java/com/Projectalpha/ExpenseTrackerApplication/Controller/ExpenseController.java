package com.Projectalpha.ExpenseTrackerApplication.Controller;

import com.Projectalpha.ExpenseTrackerApplication.entity.Expense;
import com.Projectalpha.ExpenseTrackerApplication.entity.User;
import com.Projectalpha.ExpenseTrackerApplication.service.ExpenseService;
import com.Projectalpha.ExpenseTrackerApplication.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/expenses")
public class ExpenseController {

    private final ExpenseService expenseService;
    private final UserService userService;

    public ExpenseController(ExpenseService expenseService,
                             UserService userService) {
        this.expenseService = expenseService;
        this.userService = userService;
    }

    @PostMapping
    public Expense addExpense(@RequestBody Expense expense,
                              Authentication authentication) {

        String email = authentication.getName();
        User user = userService.getUserByEmail(email);

        expense.setUser(user);
        return expenseService.addExpense(expense);
    }

    @GetMapping
    public List<Expense> getMyExpenses(Authentication authentication) {

        String email = authentication.getName();
        System.out.println("Authenticated mail: " + email+"is accessing expenses");
        User user = userService.getUserByEmail(email);

        return expenseService.getExpensesByUser(user);
    }

    @DeleteMapping("/{id}")
    public void deleteExpense(@PathVariable Long id,
                              Authentication authentication) {

        String email = authentication.getName();
        User user = userService.getUserByEmail(email);

        expenseService.deleteExpense(id, user);
    }
}
