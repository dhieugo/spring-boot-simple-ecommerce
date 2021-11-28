package com.dhieugo.ecommerce.product.controller;

import com.dhieugo.ecommerce.product.dto.request.ProductFilterRequest;
import com.dhieugo.ecommerce.product.model.Product;
import com.dhieugo.ecommerce.product.service.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<Page<Product>> searchProducts(@RequestParam(required = false) List<Long> categories,
                                                        @RequestParam(required = false) List<Long> brands,
                                                        @RequestParam(required = false) List<String> colors,
                                                        @RequestParam(required = false) String price, Pageable pageable) {
        return new ResponseEntity<>(productService.searchProducts(
                new ProductFilterRequest(categories, brands, colors, price),
                pageable
        ), HttpStatus.OK);
    }

    @GetMapping(path = "/{productId}")
    public ResponseEntity<Product> getProduct(@PathVariable long productId) {
        return new ResponseEntity<>(productService.getProductById(productId), HttpStatus.OK);
    }
}
