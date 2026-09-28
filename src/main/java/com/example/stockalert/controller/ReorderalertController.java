package com.example.stockalert.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.stockalert.model.Reorderalerts;
import com.example.stockalert.service.ReorderAlertservice;

@RestController
@RequestMapping("/reorder-alerts")
public class ReorderalertController {

    private final ReorderAlertservice reorderAlertservice;

    public ReorderalertController(ReorderAlertservice reorderAlertservice) {
        this.reorderAlertservice = reorderAlertservice;
    }

    @PostMapping
    public Reorderalerts addAlert(@RequestBody Reorderalerts alert) {
        return reorderAlertservice.addAlert(alert);
    }

    @GetMapping
    public List<Reorderalerts> getAllAlerts() {
        return reorderAlertservice.getAllAlerts();
    }

    @GetMapping("/{id}")
    public Reorderalerts getAlertById(@PathVariable Long id) {
        return reorderAlertservice.getAlertById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteAlert(@PathVariable Long id) {
        reorderAlertservice.deleteAlert(id);
    }
}