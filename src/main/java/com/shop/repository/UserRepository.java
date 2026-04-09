package com.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

import com.shop.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findByEmail(String email);

    User findByUsernameAndPassword(String username , String password );

    User findByUsername(String username);

    List<User> findByRoleIgnoreCase(String role);
}
