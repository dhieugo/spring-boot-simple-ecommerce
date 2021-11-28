package com.dhieugo.ecommerce.product.service;

import com.dhieugo.ecommerce.product.dto.request.ProductFilterRequest;
import com.dhieugo.ecommerce.product.exception.ResourceNotFoundException;
import com.dhieugo.ecommerce.product.model.Product;
import com.dhieugo.ecommerce.product.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {

    private static final Logger logger = LoggerFactory.getLogger(ProductService.class);

    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    /**
     * Load product by the search criteria
     *
     * @param productFilterRequest
     * @param pageable
     * @return
     */
    public Page<Product> searchProducts(ProductFilterRequest productFilterRequest, Pageable pageable) {
        logger.info("Searching product by query: {} and paging options: {}", productFilterRequest, pageable);
        return productRepository.findAll(productFilterRequest.buildQuery(), pageable);
    }

    /**
     * @param productId
     * @return
     */
    public Product getProductById(long productId) {
        logger.info("Get product by id: {}", productId);
        Optional<Product> p = productRepository.findById(productId);
        if (!p.isPresent()) throw new ResourceNotFoundException("The product id does not exist.");
        return p.get();
    }
}
