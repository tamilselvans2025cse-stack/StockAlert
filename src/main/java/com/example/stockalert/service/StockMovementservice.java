package com.example.stockalert.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.stockalert.model.Products;
import com.example.stockalert.model.Reorderalerts;
import com.example.stockalert.model.Stocksmovement;
import com.example.stockalert.repository.ProductsRepository;
import com.example.stockalert.repository.ReorderAlertsRepository;
import com.example.stockalert.repository.StockmovementsRepository;

@Service
public class StockMovementservice {

    private final StockmovementsRepository stockmovementsRepository;
    private final ProductsRepository productsRepository;
    private final ReorderAlertsRepository reorderAlertsRepository;

    public StockMovementservice(
            StockmovementsRepository stockmovementsRepository,
            ProductsRepository productsRepository,
            ReorderAlertsRepository reorderAlertsRepository) {

        this.stockmovementsRepository = stockmovementsRepository;
        this.productsRepository = productsRepository;
        this.reorderAlertsRepository = reorderAlertsRepository;
    }

    public Stocksmovement addMovement(Stocksmovement movement) {

        // Get product ID from the movement
        Long productId =
                movement.getProduct().getProductId();

        // Find the actual product from database
        Products existingProduct =
                productsRepository.findById(productId)
                .orElse(null);

        if (existingProduct == null) {
            return null;
        }

        // =========================
        // UPDATE PRODUCT QUANTITY
        // =========================

        if (movement.getMovementType()
                .equalsIgnoreCase("IN")) {

            existingProduct.setQuantity(
                    existingProduct.getQuantity()
                    + movement.getQuantity()
            );

        }

        else if (movement.getMovementType()
                .equalsIgnoreCase("OUT")) {

            existingProduct.setQuantity(
                    existingProduct.getQuantity()
                    - movement.getQuantity()
            );
        }

        // Save updated product
        productsRepository.save(existingProduct);


        // Attach actual product to movement
        movement.setProduct(existingProduct);


        // Set today's date
        if (movement.getMovementDate() == null) {

            movement.setMovementDate(
                    LocalDate.now()
            );

        }


        // Save movement
        Stocksmovement savedMovement =
                stockmovementsRepository.save(movement);


        // =========================
        // REORDER ALERT
        // =========================

        if (existingProduct.getQuantity()
                <= existingProduct.getReorderLevel()) {

            Reorderalerts alert =
                    new Reorderalerts();

            alert.setMessage(
                    "Low stock for "
                    + existingProduct.getProductName()
            );

            alert.setStatus("PENDING");

            alert.setAlertDate(
                    LocalDate.now()
            );

            alert.setProduct(existingProduct);

            reorderAlertsRepository.save(alert);

        }


        return savedMovement;
    }


    public List<Stocksmovement> getAllMovements() {

        return stockmovementsRepository.findAll();

    }


    public Stocksmovement getMovementById(Long id) {

        return stockmovementsRepository
                .findById(id)
                .orElse(null);

    }


    public void deleteMovement(Long id) {

        stockmovementsRepository.deleteById(id);

    }

}