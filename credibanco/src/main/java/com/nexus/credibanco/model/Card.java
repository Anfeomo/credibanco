package com.nexus.credibanco.model;

import com.nexus.credibanco.model.enums.CardType;
import com.nexus.credibanco.model.enums.CurrencyType;
import com.nexus.credibanco.model.enums.Status;
import jakarta.persistence.*;

import java.util.Date;

@Entity(name = "cards")
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "card_number", nullable = false)
    private String cardNumber;
    @Column(name = "produc_id", nullable = false)
    private String productId;
    @Column(name = "holder_name", nullable = false)
    private String holderName;
    @Column(name = "due_date", nullable = false)
    private Date dueDate;
    @Column(name = "creation_date", nullable = false)
    private Date creationDate;
    @Column(name = "balence", nullable = false)
    private String balance;
    @Enumerated
    @Column(name = "status")
    private Status status;
    @Enumerated
    @Column(name = "card_type")
    private CardType cardType;

    @Enumerated
    @Column(name = "currency_type")
    private CurrencyType currencyType;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    public Card(Long id, String productId, String holderName, Date dueDate, Date creationDate, String balance, Status status, CardType cardType) {
        this.id = id;
        this.productId = productId;
        this.holderName = holderName;
        this.dueDate = dueDate;
        this.creationDate = creationDate;
        this.balance = balance;
        this.status = status;
        this.cardType = cardType;
        this.currencyType = CurrencyType.USD;
    }

    public Card() {

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

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getHolderName() {
        return holderName;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public CardType getCardType() {
        return cardType;
    }

    public void setCardType(CardType cardType) {
        this.cardType = cardType;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public CurrencyType getCurrencyType() {
        return currencyType;
    }

    public void setCurrencyType(CurrencyType currencyType) {
        this.currencyType = currencyType;
    }


}





