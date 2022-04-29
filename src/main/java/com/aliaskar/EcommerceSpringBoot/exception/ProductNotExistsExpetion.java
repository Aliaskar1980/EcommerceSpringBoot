package com.aliaskar.EcommerceSpringBoot.exception;

/**
 * Created by Admin on 29.04.2022
 */
public class ProductNotExistsExpetion extends IllegalArgumentException {
    public ProductNotExistsExpetion(String msg) {
        super(msg);
    }
}
