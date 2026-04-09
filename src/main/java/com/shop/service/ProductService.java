package com.shop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.model.Product;
import com.shop.repository.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repo;

    public List<Product> getAllProducts() {
        return repo.findAll();
    }

    public List<Product> getByCategory(String category) {
        return repo.findByCategory(category);
    }

    public Product saveProduct(Product product) {
        return repo.save(product);
    }

    public Optional<Product> getProductById(int productId) {
        return repo.findById(productId);
    }

    public void deleteProduct(int productId) {
        repo.deleteById(productId);
    }
}
