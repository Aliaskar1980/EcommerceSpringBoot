package com.aliaskar.EcommerceSpringBoot.repository;

import com.aliaskar.EcommerceSpringBoot.model.Product;
import com.aliaskar.EcommerceSpringBoot.model.User;
import com.aliaskar.EcommerceSpringBoot.model.WishList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Admin on 26.04.2022
 */
@Repository
public interface WishListRepository extends JpaRepository<WishList, Integer> {
    WishList findByProduct(Product product);
    WishList findAllByProductAndUser(Product product, User user);
    List<WishList> findAllByUserOrderByCreatedDateDesc(User user);


}
