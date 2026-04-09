package com.shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.shop.dto.CartItem;
import com.shop.model.User;
import com.shop.service.CartService;

import jakarta.servlet.http.HttpSession;

@Controller
public class CartController {

	@Autowired
	private CartService service;

	// VIEW CART
	@GetMapping("/cart")
	public String cart(Model model, HttpSession session) {

		User user = (User) session.getAttribute("loggedUser");

		if (user == null)
			return "redirect:/login";

		List<CartItem> items = service.getCartItems(user.getUserId());

		int count = service.getCartCount(user.getUserId());

		session.setAttribute("cartCount", count);

		model.addAttribute("cartItems", items);

		return "cart";
	}

	// ADD TO CART
	@PostMapping("/add-to-cart")
	public String addToCart(@RequestParam int productId, HttpSession session) {

		User user = (User) session.getAttribute("loggedUser");

		if (user == null)
			return "redirect:/login";

		service.addToCart(productId, user.getUserId());

		int count = service.getCartCount(user.getUserId());

		session.setAttribute("cartCount", count);

		return "redirect:/products";
	}

	// INCREASE QUANTITY
	@PostMapping("/increase")
	public String increase(@RequestParam int productId, HttpSession session) {

		User user = (User) session.getAttribute("loggedUser");

		if (user == null) {
			return "redirect:/login";
		}

		service.increaseQuantity(productId, user.getUserId());

		return "redirect:/cart";
	}

	// DECREASE QUANTITY
	@PostMapping("/decrease")
	public String decrease(@RequestParam int productId, HttpSession session) {

		User user = (User) session.getAttribute("loggedUser");

		if (user == null) {
			return "redirect:/login";
		}

		service.decreaseQuantity(productId, user.getUserId());

		return "redirect:/cart";
	}

	// REMOVE ITEM
	@PostMapping("/remove")
	public String remove(@RequestParam int productId, HttpSession session) {

		User user = (User) session.getAttribute("loggedUser");

		if (user == null) {
			return "redirect:/login";
		}

		service.removeItem(productId, user.getUserId());

		return "redirect:/cart";
	}
}