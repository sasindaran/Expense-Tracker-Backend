package com.Projectalpha.ExpenseTrackerApplication.Controller;

import com.Projectalpha.ExpenseTrackerApplication.entity.User;
import com.Projectalpha.ExpenseTrackerApplication.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private final UserService userService;

    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        System.out.println("Request made");
        return userService.getAllUsers();
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }

}
