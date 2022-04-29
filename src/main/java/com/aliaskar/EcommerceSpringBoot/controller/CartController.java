package com.aliaskar.EcommerceSpringBoot.controller;

import com.aliaskar.EcommerceSpringBoot.common.ApiResponse;
import com.aliaskar.EcommerceSpringBoot.dto.cart.AddToCartDto;
import com.aliaskar.EcommerceSpringBoot.dto.cart.CartDto;
import com.aliaskar.EcommerceSpringBoot.model.User;
import com.aliaskar.EcommerceSpringBoot.service.AuthenticationService;
import com.aliaskar.EcommerceSpringBoot.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Admin on 29.04.2022
 */
@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    CartService cartService;
    @Autowired
    AuthenticationService authenticationService;

//    post cart API
    @PostMapping("/add")
    public ResponseEntity<ApiResponse> addToCart(@RequestBody AddToCartDto addToCartDto,
                                                 @RequestParam("token") String token){

        authenticationService.authenticate(token);
        User user = authenticationService.getUser(token);
        cartService.addToCart(addToCartDto, user);
        return new ResponseEntity<>(new ApiResponse(true, "Added to cart"), HttpStatus.CREATED);
    }

//    get all cart items for a user

    @GetMapping("/getCartItems")
    public  ResponseEntity<CartDto> getAllItemsForUser(@RequestParam("token") String token){
        authenticationService.authenticate(token);
        User user = authenticationService.getUser(token);
        CartDto cartDto = cartService.listCartItems(user);
        return new ResponseEntity<>(cartDto, HttpStatus.OK);
    }

//    delete cart item
    @DeleteMapping("/delete/{cartItemId}")
    public ResponseEntity<ApiResponse> deleteItemByIdFromCart(@PathVariable(    "cartItemId") Integer productId,
                                                              @RequestParam("token") String token){
        authenticationService.authenticate(token);
        User user = authenticationService.getUser(token);
        cartService.deleteCartItem(productId, user);
        return new ResponseEntity<>(new ApiResponse(true,"deleted"),HttpStatus.OK);

    }
}
