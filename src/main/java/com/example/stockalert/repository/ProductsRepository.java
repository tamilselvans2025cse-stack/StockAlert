package com.example.stockalert.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.stockalert.model.Products;

public interface ProductsRepository extends JpaRepository<Products, Long> {

}