package com.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.shop.model.User;
import com.shop.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class AuthController {

	@Autowired
	private UserService service;

	// LOGIN PAGE
	@GetMapping("/login")
	public String loginPage() {
		return "login";
	}

	// REGISTER PAGE
	@GetMapping("/register")
	public String registerPage() {
		return "register";
	}

	// LOGIN LOGIC
	@PostMapping("/login")
	public String login(@RequestParam String username, @RequestParam String password, HttpSession session,
			Model model) {

		System.out.println("LOGIN CLICKED");

		User user = service.login(username, password);

		if (user != null) {

			System.out.println("LOGIN SUCCESS");

			session.setAttribute("loggedUser", user);
			model.addAttribute("success", "Login successful!");

			if ("ADMIN".equals(user.getRole())) {
				// Keep separate admin session so /admin/** protected routes work.
				session.setAttribute("adminUser", user);
				return "redirect:/admin/dashboard";
			}
			return "redirect:/products";
		}

		System.out.println("LOGIN FAILED");

		model.addAttribute("error", "Invalid Username or Password");

		return "login";
	}

	// REGISTER LOGIC
	@PostMapping("/register")
	public String register(User user, Model model) {

		service.register(user);
		model.addAttribute("success", "Registration successful! Please login.");

		return "redirect:/login";
	}

	// LOGOUT LOGIC
	@GetMapping("/logout")
	public String logout(HttpSession session) {

		session.invalidate();

		return "redirect:/login";
	}
}