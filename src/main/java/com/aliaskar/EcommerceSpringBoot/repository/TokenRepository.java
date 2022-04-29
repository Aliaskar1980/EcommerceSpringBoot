package com.aliaskar.EcommerceSpringBoot.repository;

import com.aliaskar.EcommerceSpringBoot.model.AuthenticationToken;
import com.aliaskar.EcommerceSpringBoot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Admin on 25.04.2022
 */
@Repository
public interface TokenRepository  extends JpaRepository<AuthenticationToken,Integer> {
    AuthenticationToken findByUser(User user);
    AuthenticationToken findByToken(String token);
}
