package com.RewardProgram.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import jakarta.persistence.*;

import java.time.LocalDate;


@Entity
@Table(name = "Customer_Transaction")
public class Transaction {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transaction_Id") // This must match the DB column name
    private Integer transactionId;

    @Column(name="customerId")
    private String customerId;

    @Column(name="customerName")
    private String customerName;

    @Column(name="transactionDate")
    private LocalDate transactionDate;

    @Column(nullable = false, precision = 10, scale = 2)
    private int amount;


    public Integer getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Integer transactionId) {
        this.transactionId = transactionId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public LocalDate getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDate transactionDate) {
        this.transactionDate = transactionDate;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
