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

    
    public Reorderalerts addAlert(Reorderalerts alert) {
        return reorderAlertsRepository.save(alert);
    }

    
    public List<Reorderalerts> getAllAlerts() {
        return reorderAlertsRepository.findAll();
    }

    
    public Reorderalerts getAlertById(Long id) {
        return reorderAlertsRepository.findById(id).orElse(null);
    }

    
    public void deleteAlert(Long id) {
        reorderAlertsRepository.deleteById(id);
    }
}