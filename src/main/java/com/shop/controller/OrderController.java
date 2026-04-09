package com.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.shop.model.User;
import com.shop.service.OrderService;

@Controller
public class OrderController {

	@Autowired
	private OrderService service;

	// CHECKOUT PAGE
	@GetMapping("/checkout")
	public String checkout(Model model, @SessionAttribute("loggedUser") User user) {

		double total = service.calculateTotal(user.getUserId());
		model.addAttribute("total", total);

		return "checkout";
	}

	// PLACE ORDER
	@PostMapping("/place-order")
	public String placeOrder(@RequestParam String address, @SessionAttribute("loggedUser") User user) {

		service.placeOrder(user.getUserId(), address);

		return "redirect:/orders";
	}

	// VIEW ORDERS
	@GetMapping("/orders")
	public String orders(Model model, @SessionAttribute("loggedUser") User user) {

		model.addAttribute("orders", service.getUserOrders(user.getUserId()));

		return "orders";
	}
}
