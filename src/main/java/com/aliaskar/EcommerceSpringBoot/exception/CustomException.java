package com.aliaskar.EcommerceSpringBoot.exception;

/**
 * Created by Admin on 25.04.2022
 */
public class CustomException extends IllegalArgumentException {
    public CustomException(String msg){
        super(msg );
    }

}
