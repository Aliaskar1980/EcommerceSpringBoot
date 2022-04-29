package com.aliaskar.EcommerceSpringBoot.service;

import com.aliaskar.EcommerceSpringBoot.dto.ProductDto;
import com.aliaskar.EcommerceSpringBoot.exception.CustomException;
import com.aliaskar.EcommerceSpringBoot.model.Product;
import com.aliaskar.EcommerceSpringBoot.model.User;
import com.aliaskar.EcommerceSpringBoot.model.WishList;
import com.aliaskar.EcommerceSpringBoot.repository.ProductRepo;
import com.aliaskar.EcommerceSpringBoot.repository.WishListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by Admin on 26.04.2022
 */
@Service
public class WishListService {
    @Autowired
    WishListRepository wishListRepository;
    @Autowired
    ProductService productService;

    public void createWishList(WishList wishList) {
        wishListRepository.save(wishList);
    }


    public void checkProduct(Product product, User user) {
        if (Objects.isNull(wishListRepository.findAllByProductAndUser(product, user))){
            wishListRepository.findByProduct(product);
            return;
        }
        throw new CustomException("product is present");

    }
    public List<ProductDto> getWishListForUser(User user){
        List<WishList> wishLists = wishListRepository.findAllByUserOrderByCreatedDateDesc(user);
        List<ProductDto> productDtos = new ArrayList<>();
        for (WishList wishList: wishLists ) {
            productDtos.add(productService.getProductDto(wishList.getProduct()));

        }
        return productDtos;
    }

}
