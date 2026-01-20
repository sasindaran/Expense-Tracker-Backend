package com.Projectalpha.ExpenseTrackerApplication.repository;

import com.Projectalpha.ExpenseTrackerApplication.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Integer> {

    Optional<Role> findByName(String name);
}
