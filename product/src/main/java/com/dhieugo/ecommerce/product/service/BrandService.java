package com.dhieugo.ecommerce.product.service;

import com.dhieugo.ecommerce.product.model.Brand;
import com.dhieugo.ecommerce.product.repository.BrandRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BrandService {

    private final BrandRepository brandRepository;

    public BrandService(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    public Page<Brand> search(Pageable pageable) {
        return brandRepository.findAll(pageable);
    }
}
