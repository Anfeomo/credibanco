package com.nexus.credibanco.DTO;

import com.nexus.credibanco.model.enums.TypeTransaction;

import java.util.Date;

public class TransactionDTO {
    private Long id;
    private String cardNumber;
    private TypeTransaction type;
    private String transactionId; // Nota: Cambié a minúscula para seguir la convención de nombres de Java
    private Integer amount;
    private Date transactionDate;
    private Integer totalAmount; // Nota: Cambié a minúscula para seguir la convención de nombres de Java

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public TypeTransaction getType() {
        return type;
    }

    public void setType(TypeTransaction type) {
        this.type = type;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public Integer getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Integer totalAmount) {
        this.totalAmount = totalAmount;
    }
}

