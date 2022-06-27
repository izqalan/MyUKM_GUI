/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dev.izqalan.myukm.models;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 *
 * @author Izqalan
 */
public class PaymentModel {
    double price;
    UUID id;
    String toWhom;
    LocalDateTime createdAt;

    public PaymentModel(double price, UUID id, String toWhom, LocalDateTime createdAt) {
        this.price = price;
        this.id = id;
        this.toWhom = toWhom;
        this.createdAt = createdAt;
    }

    public double getPrice() {
        return price;
    }

    public UUID getId() {
        return id;
    }

    public String getToWhom() {
        return toWhom;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    
    
}
