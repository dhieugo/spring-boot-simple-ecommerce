package com.dhieugo.ecommerce.product.controller;

import com.dhieugo.ecommerce.product.model.Brand;
import com.dhieugo.ecommerce.product.service.BrandService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/brands")
public class BrandController {

    private final BrandService brandService;

    public BrandController(BrandService brandService) {
        this.brandService = brandService;
    }

    @GetMapping
    public ResponseEntity<Page<Brand>> searchProducts(Pageable pageable) {
        return new ResponseEntity<>(brandService.search(pageable), HttpStatus.OK);
    }
}
