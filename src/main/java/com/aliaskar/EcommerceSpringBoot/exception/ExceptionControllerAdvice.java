package com.aliaskar.EcommerceSpringBoot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Created by Admin on 25.04.2022
 */
@ControllerAdvice
public class ExceptionControllerAdvice {
    @ExceptionHandler(value = CustomException.class)
    public final ResponseEntity<String> handleCustomException(CustomException exception){
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = AuthenticationFaildException.class)
    public final ResponseEntity<String> handleAuthenicationFailException(AuthenticationFaildException exception){
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = ProductNotExistsExpetion.class)
    public final ResponseEntity<String> handleProductNotExistsExpection(ProductNotExistsExpetion expetion){
        return new ResponseEntity<>(expetion.getMessage(),HttpStatus.BAD_REQUEST);
    }
}
