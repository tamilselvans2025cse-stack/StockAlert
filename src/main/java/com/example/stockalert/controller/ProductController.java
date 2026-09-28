package com.example.stockalert.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.stockalert.model.Products;
import com.example.stockalert.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public Products addProduct(@RequestBody Products product) {
        return productService.addProduct(product);
    }

    @GetMapping
    public List<Products> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Products getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    @PutMapping("/{id}")
    public Products updateProduct(
            @PathVariable Long id,
            @RequestBody Products product) {

        return productService.updateProduct(id, product);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }
}