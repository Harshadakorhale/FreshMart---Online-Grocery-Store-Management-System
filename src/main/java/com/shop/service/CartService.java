package com.shop.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.dto.CartItem;
import com.shop.model.Cart;
import com.shop.model.Product;
import com.shop.repository.CartRepository;
import com.shop.repository.ProductRepository;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepo;

    @Autowired
    private ProductRepository productRepo;

    public List<CartItem> getCartItems(int userId) {

        List<Cart> cartList = cartRepo.findByUserId(userId);

        List<CartItem> items = new ArrayList<>();

        for (Cart c : cartList) {

            Product p = productRepo.findById(c.getProductId()).orElse(null);

            if (p != null) {
                items.add(new CartItem(
                        p.getProductId(),
                        p.getName(),
                        p.getPrice(),
                        p.getImageUrl(),
                        c.getQuantity()
                ));
            }
        }

        return items;
    }
    
    public void increaseQuantity(int productId, int userId) {
        Cart cart = cartRepo.findByUserIdAndProductId(userId, productId);

        if (cart != null) {
            cart.setQuantity(cart.getQuantity() + 1);
            cartRepo.save(cart);
        }
    }

    public void decreaseQuantity(int productId, int userId) {
        Cart cart = cartRepo.findByUserIdAndProductId(userId, productId);

        if (cart != null) {
            if (cart.getQuantity() > 1) {
                cart.setQuantity(cart.getQuantity() - 1);
                cartRepo.save(cart);
            } else {
                cartRepo.delete(cart); // remove if quantity = 1
            }
        }
    }

    public void removeItem(int productId, int userId) {
        Cart cart = cartRepo.findByUserIdAndProductId(userId, productId);

        if (cart != null) {
            cartRepo.delete(cart);
        }
    }
    
    public void addToCart(int productId, int userId) {

        Cart existing = cartRepo.findByUserIdAndProductId(userId, productId);

        if (existing != null) {
            existing.setQuantity(existing.getQuantity() + 1);
            cartRepo.save(existing);
        } else {
            Cart cart = new Cart();
            cart.setProductId(productId);
            cart.setUserId(userId);
            cart.setQuantity(1);
            cartRepo.save(cart);
        }
    }
    public int getCartCount(int userId) {

        return cartRepo.getCartCount(userId);
    }

	
}
