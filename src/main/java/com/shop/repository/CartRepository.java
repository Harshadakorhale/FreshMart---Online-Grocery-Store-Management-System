package com.shop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.shop.model.Cart;

public interface CartRepository extends JpaRepository<Cart, Integer> {
    List<Cart> findByUserId(int userId);
    
    Cart findByUserIdAndProductId(int userId, int productId);

	int countByUserId(int userId);

	@Query("SELECT COALESCE(SUM(c.quantity),0) FROM Cart c WHERE c.userId = :userId")
	Integer getCartCount(@Param("userId") int userId);
}



