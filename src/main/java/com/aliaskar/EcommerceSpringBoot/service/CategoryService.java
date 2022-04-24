package com.aliaskar.EcommerceSpringBoot.service;

import com.aliaskar.EcommerceSpringBoot.model.Category;
import com.aliaskar.EcommerceSpringBoot.repository.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Admin on 24.04.2022
 */
@Service
public class CategoryService {
    @Autowired
    private final CategoryRepo categoryRepo;

    public CategoryService(CategoryRepo categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

    public void createCategory(Category category) {
        categoryRepo.save(category);
    }

    public List<Category> getAllCategory() {
        return categoryRepo.findAll();
    }


    public void editCategory(int categoryId, Category updateCategory) {
        Category categoryById = categoryRepo.getById(categoryId);
        categoryById.setCategoryName(updateCategory.getCategoryName());
        categoryById.setDescription(updateCategory.getDescription());
        categoryById.setImageUrl(updateCategory.getImageUrl());
        categoryRepo.save(categoryById);
    }

    public boolean findById(int categoryId) {
        return categoryRepo.findById(categoryId).isPresent();
    }
}
