package com.shop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shop.model.Orders;

public interface OrderRepository extends JpaRepository<Orders, Integer> {
	List<Orders> findByUserId(int userId);
}
