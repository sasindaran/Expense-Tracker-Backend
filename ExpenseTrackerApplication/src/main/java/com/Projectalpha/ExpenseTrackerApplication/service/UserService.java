package com.Projectalpha.ExpenseTrackerApplication.service;

import com.Projectalpha.ExpenseTrackerApplication.entity.User;
import com.Projectalpha.ExpenseTrackerApplication.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }
}
