package com.shop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.model.Cart;
import com.shop.model.Orders;
import com.shop.model.Product;
import com.shop.repository.CartRepository;
import com.shop.repository.OrderRepository;
import com.shop.repository.ProductRepository;

@Service
public class OrderService {

    @Autowired
    private CartRepository cartRepo;

    @Autowired
    private ProductRepository productRepo;

    @Autowired
    private OrderRepository orderRepo;

    public double calculateTotal(int userId) {

        List<Cart> cartList = cartRepo.findByUserId(userId);
        double total = 0;

        for (Cart c : cartList) {
            Product p = productRepo.findById(c.getProductId()).orElse(null);
            if (p != null) {
                total += p.getPrice() * c.getQuantity();
            }
        }

        return total;
    }

    public void placeOrder(int userId, String address) {

        double total = calculateTotal(userId);

        Orders order = new Orders();
        order.setUserId(userId);
        order.setTotalAmount(total);
        order.setStatus("Order Confirmed");
        order.setAddress(address);

        orderRepo.save(order);

        // CLEAR CART AFTER ORDER
        cartRepo.deleteAll(cartRepo.findByUserId(userId));
    }

    public List<Orders> getUserOrders(int userId) {
        return orderRepo.findByUserId(userId);
    }

    public List<Orders> getAllOrders() {
        return orderRepo.findAll();
    }
}