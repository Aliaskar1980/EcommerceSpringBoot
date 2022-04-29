package com.aliaskar.EcommerceSpringBoot.dto.cart;

import com.aliaskar.EcommerceSpringBoot.model.Cart;
import com.aliaskar.EcommerceSpringBoot.model.Product;

import java.util.List;

/**
 * Created by Admin on 29.04.2022
 */
public class CartItemDto {
    private Integer id;
    private Integer quantuty;
    private Product protuct;

    public CartItemDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuantuty() {
        return quantuty;
    }

    public void setQuantuty(Integer quantuty) {
        this.quantuty = quantuty;
    }

    public Product getProtuct() {
        return protuct;
    }

    public void setProtuct(Product protuct) {
        this.protuct = protuct;
    }

    public CartItemDto(Cart cart) {
        this.id = cart.getId();
        this.quantuty = cart.getQuantity();
        this.setProtuct(cart.getProduct());

    }
}
