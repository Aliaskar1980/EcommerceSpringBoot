package com.aliaskar.EcommerceSpringBoot.repository;

import com.aliaskar.EcommerceSpringBoot.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Admin on 24.04.2022
 */
@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {
}
