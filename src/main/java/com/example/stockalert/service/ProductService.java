package com.example.stockalert.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.stockalert.model.Products;
import com.example.stockalert.model.Reorderalerts;
import com.example.stockalert.repository.ProductsRepository;
import com.example.stockalert.repository.ReorderAlertsRepository;

@Service
public class ProductService {

    private final ProductsRepository productsRepository;
    private final ReorderAlertsRepository reorderAlertsRepository;

    public ProductService(
            ProductsRepository productsRepository,
            ReorderAlertsRepository reorderAlertsRepository) {

        this.productsRepository = productsRepository;
        this.reorderAlertsRepository = reorderAlertsRepository;
    }

    // Add product
    public Products addProduct(Products product) {

        Products savedProduct = productsRepository.save(product);

        // Check if stock is low
        if (savedProduct.getQuantity() <= savedProduct.getReorderLevel()) {

            Reorderalerts alert = new Reorderalerts();

            alert.setMessage(
                    "Low stock for " + savedProduct.getProductName()
            );

            alert.setStatus("PENDING");

            alert.setAlertDate(LocalDate.now());

            alert.setProduct(savedProduct);

            reorderAlertsRepository.save(alert);
        }

        return savedProduct;
    }

    // Get all products
    public List<Products> getAllProducts() {
        return productsRepository.findAll();
    }

    // Get product by ID
    public Products getProductById(Long id) {
        return productsRepository.findById(id).orElse(null);
    }

    // Update product
    public Products updateProduct(Long id, Products product) {

        Products existing = productsRepository.findById(id).orElse(null);

        if (existing == null) {
            return null;
        }

        existing.setProductName(product.getProductName());
        existing.setCategory(product.getCategory());
        existing.setPrice(product.getPrice());
        existing.setQuantity(product.getQuantity());
        existing.setReorderLevel(product.getReorderLevel());

        Products updatedProduct = productsRepository.save(existing);

        // Check stock after update
        if (updatedProduct.getQuantity() <= updatedProduct.getReorderLevel()) {

            Reorderalerts alert = new Reorderalerts();

            alert.setMessage(
                    "Low stock for " + updatedProduct.getProductName()
            );

            alert.setStatus("PENDING");

            alert.setAlertDate(LocalDate.now());

            alert.setProduct(updatedProduct);

            reorderAlertsRepository.save(alert);
        }

        return updatedProduct;
    }

    // Delete product
    public void deleteProduct(Long id) {
        productsRepository.deleteById(id);
    }
}