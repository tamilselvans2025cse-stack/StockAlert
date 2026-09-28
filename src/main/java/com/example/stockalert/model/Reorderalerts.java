package com.example.stockalert.model;
import jakarta.persistence.*;
import java.time.LocalDate;
@Entity
@Table(name = "reorder_alerts")
public class Reorderalerts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long alertId;
    private String message;
    private String status;
    private LocalDate alertDate;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Products product;
    public Reorderalerts() {
    }
    public Long getAlertId() {
        return alertId;
    }
    public void setAlertId(Long alertId) {
        this.alertId = alertId;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public LocalDate getAlertDate() {
        return alertDate;
    }
    public void setAlertDate(LocalDate alertDate) {
        this.alertDate = alertDate;
    }
    public Products getProduct() {
        return product;
    }
    public void setProduct(Products product) {
        this.product = product;
    }
}