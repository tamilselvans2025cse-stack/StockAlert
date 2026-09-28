package com.example.stockalert.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.stockalert.model.Stocksmovement;
import com.example.stockalert.service.StockMovementservice;

@RestController
@RequestMapping("/stock-movements")
public class StockmovementController {

    private final StockMovementservice stockMovementservice;
    public StockmovementController(StockMovementservice stockMovementservice) {
        this.stockMovementservice = stockMovementservice;
    }
    @PostMapping
    public Stocksmovement addMovement(@RequestBody Stocksmovement movement) {
        return stockMovementservice.addMovement(movement);
    }

    @GetMapping
    public List<Stocksmovement> getAllMovements() {
        return stockMovementservice.getAllMovements();
    }

    @GetMapping("/{id}")
    public Stocksmovement getMovementById(@PathVariable Long id) {
        return stockMovementservice.getMovementById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteMovement(@PathVariable Long id) {
        stockMovementservice.deleteMovement(id);
    }
}