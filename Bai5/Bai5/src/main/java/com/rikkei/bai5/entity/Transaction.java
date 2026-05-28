package com.rikkei.bai5.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String walletAddress;
    private double amount;
    private double amountInUsd;
    private String status; // SUCCESS, PENDING_APPROVAL
    private LocalDateTime createdAt;

    // Constructors
    public Transaction() {}

    public Transaction(String walletAddress, double amount, double amountInUsd, String status) {
        this.walletAddress = walletAddress;
        this.amount = amount;
        this.amountInUsd = amountInUsd;
        this.status = status;
        this.createdAt = LocalDateTime.now();
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getWalletAddress() { return walletAddress; }
    public void setWalletAddress(String walletAddress) { this.walletAddress = walletAddress; }
    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }
    public double getAmountInUsd() { return amountInUsd; }
    public void setAmountInUsd(double amountInUsd) { this.amountInUsd = amountInUsd; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}