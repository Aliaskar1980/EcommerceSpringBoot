package com.aliaskar.EcommerceSpringBoot.controller;

import com.aliaskar.EcommerceSpringBoot.common.ApiResponse;
import com.aliaskar.EcommerceSpringBoot.model.Category;
import com.aliaskar.EcommerceSpringBoot.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Created by Admin on 24.04.2022
 */
@RestController
@AllArgsConstructor
@RequestMapping("/category")
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping("/create")
    public ResponseEntity<ApiResponse> createCategory(@RequestBody Category category) {
        categoryService.createCategory(category);
        return new ResponseEntity<>(new ApiResponse (true,"created new category"), HttpStatus.CREATED );
    }

    @GetMapping("/listAll")
    public List<Category> getAllCategory() {
      return   categoryService.getAllCategory();
    }

    @PostMapping("/update/{categoryId}")
    public ResponseEntity<ApiResponse> updateCategory(@PathVariable("categoryId") int categoryId,
                                 @RequestBody Category category){

        if (!categoryService.findById(categoryId)){
            return new ResponseEntity<>(new ApiResponse(false,"category does not exist"),HttpStatus.NOT_FOUND);
        }
        categoryService.editCategory(categoryId, category);
        return new ResponseEntity<>(new ApiResponse(true,"category has been updated"),HttpStatus.OK);
    }
}
