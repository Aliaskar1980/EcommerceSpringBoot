package com.aliaskar.EcommerceSpringBoot.exception;

/**
 * Created by Admin on 26.04.2022
 */
public class AuthenticationFaildException extends IllegalArgumentException{
    public AuthenticationFaildException(String msg){
        super(msg);
    }
}
