package com.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.shop.model.User;
import com.shop.service.OrderService;
import com.shop.service.ProductService;
import com.shop.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class AdminController {

    @Autowired
    private UserService userService;

    @Autowired
    private ProductService productService;

    @Autowired
    private OrderService orderService;

    @GetMapping("/admin/login")
    public String adminLoginPage(HttpSession session) {
        if (session.getAttribute("adminUser") != null) {
            return "redirect:/admin/dashboard";
        }
        return "admin-login";
    }

    @GetMapping("/admin")
    public String adminRoot() {
        return "redirect:/admin/dashboard";
    }

    @PostMapping("/admin/login")
    public String adminLogin(@RequestParam String username, @RequestParam String password, Model model, HttpSession session) {
        User admin = userService.adminLogin(username, password);
        if (admin == null) {
            model.addAttribute("error", "Invalid admin credentials");
            return "admin-login";
        }

        session.setAttribute("adminUser", admin);
        return "redirect:/admin/dashboard";
    }

    @GetMapping("/admin/logout")
    public String adminLogout(HttpSession session) {
        session.removeAttribute("adminUser");
        return "redirect:/admin/login";
    }

    @GetMapping("/admin/dashboard")
    public String adminDashboard(Model model) {
        model.addAttribute("productCount", productService.getAllProducts().size());
        model.addAttribute("customerCount", userService.getCustomers().size());
        return "admin-dashboard";
    }

    @GetMapping("/admin/customers")
    public String customers(Model model) {
        model.addAttribute("customers", userService.getCustomers());
        return "admin-customers";
    }

    @GetMapping("/admin/orders")
    public String adminOrders(Model model) {
        model.addAttribute("orders", orderService.getAllOrders());
        return "admin-orders";
    }

    @GetMapping("/admin-dashboard")
    public String legacyAdminDashboardRedirect() {
        return "redirect:/admin/dashboard";
    }
}
