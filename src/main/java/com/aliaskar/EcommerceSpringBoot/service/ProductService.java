package com.aliaskar.EcommerceSpringBoot.service;

import com.aliaskar.EcommerceSpringBoot.dto.ProductDto;
import com.aliaskar.EcommerceSpringBoot.model.Category;
import com.aliaskar.EcommerceSpringBoot.model.Product;
import com.aliaskar.EcommerceSpringBoot.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by Admin on 24.04.2022
 */
@Service
public class ProductService {
    @Autowired
    ProductRepo productRepo;

    public void createProduct(ProductDto productDto, Category category) {
        Product product = new Product();
        product.setName(productDto.getName());
        product.setDescription(productDto.getDescription());
        product.setImageUrl(productDto.getImageUrl());
        product.setCategory(category);
        product.setPrice(productDto.getPrice());
        productRepo.save(product);
    }

    public ProductDto getProductDto(Product product){
        ProductDto productDto = new ProductDto();
        productDto.setName(product.getName());
        productDto.setDescription(product.getDescription());
        productDto.setCategoryId(product.getCategory().getId());
        productDto.setPrice(product.getPrice());
        productDto.setId(product.getId());
        return productDto;
    }

    public List<ProductDto> getAllProducts() {
        List<Product> allProducts= productRepo.findAll();
        List<ProductDto> productDtos = new ArrayList<>();
        for (Product product: allProducts   ) {
            productDtos.add(getProductDto(product));
        }
        return productDtos;
    }

    public void updateProduct(ProductDto productDto, Integer productId) throws Exception {
        Optional<Product> optionalProduct = productRepo.findById(productId);
//        throw an exception if product does not exist
        if (!optionalProduct.isPresent()){
            throw new Exception("product not present");
        }
        Product product = optionalProduct.get();
        product.setName(productDto.getName());
        product.setDescription(productDto.getDescription());
        product.setImageUrl(productDto.getImageUrl());
        product.setPrice(productDto.getPrice());
        productRepo.save(product);

    }
}
