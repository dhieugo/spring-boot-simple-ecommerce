package com.dhieugo.ecommerce.product.controller;

import com.dhieugo.ecommerce.product.model.Category;
import com.dhieugo.ecommerce.product.service.CategoryService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public ResponseEntity<Page<Category>> searchProducts(Pageable pageable) {
        return new ResponseEntity<>(categoryService.searchCategory(pageable), HttpStatus.OK);
    }
}
