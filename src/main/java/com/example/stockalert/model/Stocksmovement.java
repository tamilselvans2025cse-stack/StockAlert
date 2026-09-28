package com.example.stockalert.model;
import jakarta.persistence.*;
import java.time.LocalDate;
@Entity
@Table(name = "stock_movements")
public class Stocksmovement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long movementId;
    private int quantity;
    private String movementType;
    private LocalDate movementDate;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Products product;
    public Stocksmovement() {
    }
    public Long getMovementId() {
        return movementId;
    }
    public void setMovementId(Long movementId) {
        this.movementId = movementId;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public String getMovementType() {
        return movementType;
    }
    public void setMovementType(String movementType) {
        this.movementType = movementType;
    }
    public LocalDate getMovementDate() {
        return movementDate;
    }
    public void setMovementDate(LocalDate movementDate) {
        this.movementDate = movementDate;
    }
    public Products getProduct() {
        return product;
    }
    public void setProduct(Products product) {
        this.product = product;
    }
}