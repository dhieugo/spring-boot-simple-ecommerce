package com.dhieugo.ecommerce.product.repository;

import com.dhieugo.ecommerce.product.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepositoy extends JpaRepository<Category, Long> {
}
