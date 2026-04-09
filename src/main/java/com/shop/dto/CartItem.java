package com.shop.dto;



import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CartItem {

    private int productId;
    private String name;
    private double price;
    private String imageUrl;
    private int quantity;
}
