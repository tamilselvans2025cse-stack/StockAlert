package com.example.stockalert.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.stockalert.model.Stocksmovement;
import com.example.stockalert.repository.StockmovementsRepository;

@Service
public class StockMovementservice {

    private final StockmovementsRepository stockmovementsRepository;

    public StockMovementservice(StockmovementsRepository stockmovementsRepository) {
        this.stockmovementsRepository = stockmovementsRepository;
    }

    public Stocksmovement addMovement(Stocksmovement movement) {
        return stockmovementsRepository.save(movement);
    }

    public List<Stocksmovement> getAllMovements() {
        return stockmovementsRepository.findAll();
    }

    public Stocksmovement getMovementById(Long id) {
        return stockmovementsRepository.findById(id).orElse(null);
    }

    public void deleteMovement(Long id) {
        stockmovementsRepository.deleteById(id);
    }
}