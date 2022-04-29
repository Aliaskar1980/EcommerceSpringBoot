package com.aliaskar.EcommerceSpringBoot.controller;

import com.aliaskar.EcommerceSpringBoot.common.ApiResponse;
import com.aliaskar.EcommerceSpringBoot.dto.ProductDto;
import com.aliaskar.EcommerceSpringBoot.model.Product;
import com.aliaskar.EcommerceSpringBoot.model.User;
import com.aliaskar.EcommerceSpringBoot.model.WishList;
import com.aliaskar.EcommerceSpringBoot.service.AuthenticationService;
import com.aliaskar.EcommerceSpringBoot.service.WishListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 26.04.2022
 */
@RestController
@RequestMapping("/wishlist")
public class WishListController {
    @Autowired
    WishListService wishListService;

    @Autowired
    AuthenticationService authenticationService;


    //    save product in wishlist, item authenticate the token, find the user, save the item in wishList
    @PostMapping("/add")
    public ResponseEntity<ApiResponse> addToWishList(@RequestBody Product product,
                                                     @RequestParam("token") String token) {
        authenticationService.authenticate(token);
        User user = authenticationService.getUser(token);

        WishList wishList = new WishList(user, product);
        List<WishList> wishLists = new ArrayList<>();

        wishListService.checkProduct(product, user);

        wishListService.createWishList(wishList);
        ApiResponse apiResponse = new ApiResponse(true, "added to wishList");
        return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
    }

//      get all wishlist  item for user

    @GetMapping("/{token}")
    public ResponseEntity<List<ProductDto>> getWishList(@PathVariable("token") String token) {
        authenticationService.authenticate(token);
        User user = authenticationService.getUser(token);
        List<ProductDto> productDtos = wishListService.getWishListForUser(user);
        return new ResponseEntity<>(productDtos, HttpStatus.OK);
    }

}
