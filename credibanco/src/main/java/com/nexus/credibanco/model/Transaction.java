package com.nexus.credibanco.model;

import com.nexus.credibanco.model.enums.TypeTransaction;
import jakarta.persistence.*;

import java.util.Date;

@Entity(name = "transaction")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "card_number", nullable = false)
    private String cardNumber;
    @Enumerated
    @Column(name = "transaction_type", nullable = false)
    private TypeTransaction type;
    @Column(name = "transaction_id", nullable = false)
    private String transactionId;
    @Column(name = "amount", nullable = false)
    private Integer amount;
    @Column(name = "transaction_date", nullable = false)
    private Date transactionDate;
    @Column(name = "total_amount", nullable = false)
    private Integer totalAmount;

    @ManyToOne
    @JoinColumn(name = "card_id")
    private Card card;

    public Transaction(Long id, String cardNumber, TypeTransaction type, String transactionId, Integer amount, Date transactionDate, Integer totalAmount, Card card) {
        this.id = id;
        this.cardNumber = cardNumber;
        this.type = type;
        this.transactionId = transactionId;
        this.amount = amount;
        this.transactionDate = transactionDate;
        this.totalAmount = totalAmount;
        this.card = card;
    }

    public Transaction() {

    }

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
        transactionId = transactionId;
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
        totalAmount = totalAmount;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }
}

