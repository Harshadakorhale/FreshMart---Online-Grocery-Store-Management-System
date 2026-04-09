package com.shop.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.shop.model.Product;
import com.shop.service.ProductService;

@Controller
public class AdminProductController {

    @Autowired
    private ProductService service;

    @GetMapping("/admin/products")
    public String viewProducts(Model model) {
        List<Product> list = service.getAllProducts();
        model.addAttribute("products", list);
        return "admin-products";
    }

    @GetMapping("/admin/products/new")
    public String addProductPage(Model model) {
        model.addAttribute("product", new Product());
        model.addAttribute("formMode", "create");
        return "admin-product-form";
    }

    @PostMapping("/admin/products")
    public String saveProduct(@ModelAttribute Product product) {
        service.saveProduct(product);
        return "redirect:/admin/products";
    }

    @GetMapping("/admin/products/edit/{id}")
    public String editProductPage(@PathVariable("id") int id, Model model) {
        Optional<Product> productOpt = service.getProductById(id);
        if (productOpt.isEmpty()) {
            return "redirect:/admin/products";
        }

        model.addAttribute("product", productOpt.get());
        model.addAttribute("formMode", "edit");
        return "admin-product-form";
    }

    @PostMapping("/admin/products/update")
    public String updateProduct(@ModelAttribute Product product) {
        service.saveProduct(product);
        return "redirect:/admin/products";
    }

    @GetMapping("/admin/products/delete/{id}")
    public String deleteProduct(@PathVariable("id") int id) {
        service.deleteProduct(id);
        return "redirect:/admin/products";
    }

    @GetMapping("/admin-products")
    public String legacyProductsRedirect() {
        return "redirect:/admin/products";
    }
}
