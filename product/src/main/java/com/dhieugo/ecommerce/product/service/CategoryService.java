package com.dhieugo.ecommerce.product.service;

import com.dhieugo.ecommerce.product.model.Category;
import com.dhieugo.ecommerce.product.repository.CategoryRepositoy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    private final CategoryRepositoy categoryRepositoy;

    public CategoryService(CategoryRepositoy categoryRepositoy) {
        this.categoryRepositoy = categoryRepositoy;
    }

    public Page<Category> searchCategory(Pageable pageable) {
        return categoryRepositoy.findAll(pageable);
    }
}
