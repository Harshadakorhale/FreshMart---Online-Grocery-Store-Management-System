package com.shop;

import java.util.HashSet;
import java.util.Set;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.shop.model.Product;
import com.shop.model.User;
import com.shop.repository.ProductRepository;
import com.shop.repository.UserRepository;

@SpringBootApplication
public class FreshMartApplication {

	public static void main(String[] args) {
		SpringApplication.run(FreshMartApplication.class, args);
		System.err.println("Welcome to Online grocery Store...");
        System.out.println();
	
	}

	@Bean
	CommandLineRunner initAdmin(UserRepository userRepository) {
		return args -> {
			User existingAdmin = userRepository.findByUsername("admin");
			if (existingAdmin == null) {
				User admin = new User();
				admin.setName("Administrator");
				admin.setUsername("admin");
				admin.setEmail("admin@freshmart.com");
				admin.setPassword("admin123");
				admin.setRole("ADMIN");
				userRepository.save(admin);
				
			}
		};
	}
	
	

	
	@Bean
	CommandLineRunner initProducts(ProductRepository productRepository) {
		return args -> {
			Set<String> existingKeys = new HashSet<>();
			for (Product product : productRepository.findAll()) {
				existingKeys.add(keyOf(product.getName(), product.getCategory()));
			}

			addProductIfMissing(productRepository, existingKeys, "Apple", "Fruits", 120, 80, "apple.jpg", "Fresh and crispy red apples.");
			addProductIfMissing(productRepository, existingKeys, "Banana", "Fruits", 60, 120, "banana.jpg", "Naturally sweet bananas rich in potassium.");
			addProductIfMissing(productRepository, existingKeys, "Orange", "Fruits", 90, 75, "orange.jpg", "Juicy oranges packed with vitamin C.");
			addProductIfMissing(productRepository, existingKeys, "Tomato", "Vegetables", 40, 150, "tomato.jpg", "Farm fresh tomatoes for daily cooking.");
			addProductIfMissing(productRepository, existingKeys, "Potato", "Vegetables", 30, 200, "potato.jpg", "Quality potatoes suitable for all dishes.");
			addProductIfMissing(productRepository, existingKeys, "Onion", "Vegetables", 35, 160, "onion.jpg", "Fresh onions with strong flavor.");
			addProductIfMissing(productRepository, existingKeys, "Milk 1L", "Dairy", 58, 90, "milk.jpg", "Pure toned milk - 1 liter pack.");
			addProductIfMissing(productRepository, existingKeys, "Paneer", "Dairy", 110, 70, "paneer.jpg", "Soft and fresh paneer for meals.");
			addProductIfMissing(productRepository, existingKeys, "Curd", "Dairy", 45, 85, "curd.jpg", "Thick and creamy fresh curd.");
			addProductIfMissing(productRepository, existingKeys, "Butter", "Dairy", 65, 60, "butter.jpg", "Smooth salted butter for cooking.");
			addProductIfMissing(productRepository, existingKeys, "Mango", "Fruits", 140, 50, "mango.jpg", "Seasonal ripe mangoes full of flavor.");
			addProductIfMissing(productRepository, existingKeys, "Carrot", "Vegetables", 55, 95, "carrot.jpg", "Crunchy carrots ideal for salads and curries.");
			addProductIfMissing(productRepository, existingKeys, "Brown Bread", "Bakery", 45, 70, "brown-bread.jpg", "Freshly baked brown bread loaf.");
			addProductIfMissing(productRepository, existingKeys, "Burger Buns", "Bakery", 35, 80, "burger-buns.jpg", "Soft bakery buns for burgers.");
			addProductIfMissing(productRepository, existingKeys, "Croissant", "Bakery", 55, 60, "croissant.jpg", "Flaky and buttery classic croissant.");
			addProductIfMissing(productRepository, existingKeys, "Milk Chocolate", "Snacks & Desserts", 40, 120, "milk-chocolate.jpg", "Smooth milk chocolate bar.");
			addProductIfMissing(productRepository, existingKeys, "Dark Chocolate", "Snacks & Desserts", 55, 90, "dark-chocolate.jpg", "Rich dark chocolate with deep cocoa flavor.");
			addProductIfMissing(productRepository, existingKeys, "Vanilla Ice Cream", "Snacks & Desserts", 120, 60, "vanilla-icecream.jpg", "Creamy vanilla ice cream tub.");
			addProductIfMissing(productRepository, existingKeys, "Chocolate Ice Cream", "Snacks & Desserts", 130, 55, "chocolate-icecream.jpg", "Classic chocolate ice cream tub.");
			addProductIfMissing(productRepository, existingKeys, "Cola 750ml", "Cold Beverages", 40, 110, "cola.jpg", "Refreshing chilled cola drink.");
			addProductIfMissing(productRepository, existingKeys, "Orange Soda 750ml", "Cold Beverages", 38, 95, "orange-soda.jpg", "Sparkling orange flavored soda.");
			addProductIfMissing(productRepository, existingKeys, "Lemon Iced Tea 500ml", "Cold Beverages", 45, 80, "lemon-iced-tea.jpg", "Cool lemon iced tea bottle.");
			addProductIfMissing(productRepository, existingKeys, "Mango Juice 1L", "Cold Beverages", 95, 70, "mango-juice.jpg", "Sweet and fresh mango juice.");
		};
	}

	private void addProductIfMissing(ProductRepository productRepository, Set<String> existingKeys, String name, String category, double price, int quantity, String imageUrl, String description) {
		String key = keyOf(name, category);
		if (existingKeys.contains(key)) {
			return;
		}

		Product product = new Product();
		product.setName(name);
		product.setCategory(category);
		product.setPrice(price);
		product.setQuantity(quantity);
		product.setImageUrl(imageUrl);
		product.setDescription(description);
		productRepository.save(product);
		existingKeys.add(key);
	}

	private String keyOf(String name, String category) {
		String safeName = name == null ? "" : name.trim().toLowerCase();
		String safeCategory = category == null ? "" : category.trim().toLowerCase();
		return safeName + "::" + safeCategory;
	}
}
