package com.shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.shop.model.Product;
import com.shop.service.ProductService;

@Controller
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping("/products")
    public String products(@RequestParam(required = false) String category, Model model) {

        List<Product> list;

        if (category != null) {
            list = service.getByCategory(category);
        } else {
            list = service.getAllProducts();
        }

        model.addAttribute("products", list);
        return "products";
    }
}