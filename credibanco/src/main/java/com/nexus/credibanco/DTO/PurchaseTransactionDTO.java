package com.nexus.credibanco.DTO;

public class PurchaseTransactionDTO {
    private String cardNumber;
    private String price;

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
