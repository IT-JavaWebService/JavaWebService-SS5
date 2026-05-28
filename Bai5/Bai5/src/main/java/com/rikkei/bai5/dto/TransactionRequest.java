package com.rikkei.bai5.dto;

public class TransactionRequest {
    private String walletAddress;
    private double amount;
    private double amountInUsd;

    // Getters and Setters
    public String getWalletAddress() { return walletAddress; }
    public void setWalletAddress(String walletAddress) { this.walletAddress = walletAddress; }
    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }
    public double getAmountInUsd() { return amountInUsd; }
    public void setAmountInUsd(double amountInUsd) { this.amountInUsd = amountInUsd; }
}