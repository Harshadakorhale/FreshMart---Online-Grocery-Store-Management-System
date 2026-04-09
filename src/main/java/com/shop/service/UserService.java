package com.shop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.model.User;
import com.shop.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public User login(String username, String password) {

        User user = repo.findByEmail(username);

     
        if (user == null) {
            user = repo.findByUsernameAndPassword(username,password);
        }

        if (user != null && user.getPassword().equals(password)) {
            return user;
        }

        return null;
    }

    public void register(User user) {
        user.setRole("USER");
        repo.save(user);
    }

    public User adminLogin(String usernameOrEmail, String password) {
        User user = repo.findByEmail(usernameOrEmail);
        if (user == null) {
            user = repo.findByUsername(usernameOrEmail);
        }

        if (user != null && "ADMIN".equalsIgnoreCase(user.getRole()) && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }

    public List<User> getCustomers() {
        return repo.findByRoleIgnoreCase("USER");
    }
}
