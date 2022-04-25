package com.aliaskar.EcommerceSpringBoot.repository;

import com.aliaskar.EcommerceSpringBoot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Admin on 25.04.2022
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByEmail(String email);
}
