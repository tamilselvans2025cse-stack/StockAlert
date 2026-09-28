package com.example.stockalert.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.stockalert.model.Reorderalerts;
import com.example.stockalert.repository.ReorderAlertsRepository;

@Service
public class ReorderAlertservice {

    private final ReorderAlertsRepository reorderAlertsRepository;

    public ReorderAlertservice(ReorderAlertsRepository reorderAlertsRepository) {
        this.reorderAlertsRepository = reorderAlertsRepository;
    }

    // Add alert
    public Reorderalerts addAlert(Reorderalerts alert) {
        return reorderAlertsRepository.save(alert);
    }

    // Get all alerts
    public List<Reorderalerts> getAllAlerts() {
        return reorderAlertsRepository.findAll();
    }

    // Get alert by ID
    public Reorderalerts getAlertById(Long id) {
        return reorderAlertsRepository.findById(id).orElse(null);
    }

    // Delete alert
    public void deleteAlert(Long id) {
        reorderAlertsRepository.deleteById(id);
    }
}