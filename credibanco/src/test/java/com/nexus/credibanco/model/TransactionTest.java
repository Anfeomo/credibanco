package com.nexus.credibanco.model;

import com.nexus.credibanco.model.Card;
import com.nexus.credibanco.model.Transaction;
import com.nexus.credibanco.model.enums.TypeTransaction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

public class TransactionTest {

    @InjectMocks
    private Transaction transaction;

    @Mock
    private Card card;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        transaction = new Transaction();
    }

    @Test
    public void testTransactionCreation() {
        assertNotNull(transaction);
    }

    @Test
    public void testTransactionFields() {
        Long id = 1L;
        String cardNumber = "1234567890123456";
        TypeTransaction type = TypeTransaction.PURCHASE;
        String transactionId = "TXN12345";
        Integer amount = 100;
        Date transactionDate = new Date();
        Integer totalAmount = 1000;

        transaction.setId(id);
        transaction.setCardNumber(cardNumber);
        transaction.setType(type);
        transaction.setTransactionId(transactionId);
        transaction.setAmount(amount);
        transaction.setTransactionDate(transactionDate);
        transaction.setTotalAmount(totalAmount);
        transaction.setCard(card);

        assertEquals(id, transaction.getId());
        assertEquals(cardNumber, transaction.getCardNumber());
        assertEquals(type, transaction.getType());
        assertEquals(transactionId, transaction.getTransactionId());
        assertEquals(amount, transaction.getAmount());
        assertEquals(transactionDate, transaction.getTransactionDate());
        assertEquals(totalAmount, transaction.getTotalAmount());
        assertEquals(card, transaction.getCard());
    }

    @Test
    public void testTransactionAmountUpdate() {
        Integer newAmount = 200;
        transaction.setAmount(newAmount);
        assertEquals(newAmount, transaction.getAmount());
    }

    @Test
    public void testTransactionCardUpdate() {
        Card newCard = new Card();
        newCard.setId(2L);
        transaction.setCard(newCard);
        assertEquals(newCard, transaction.getCard());
    }

    @Test
    public void testTransactionTypeUpdate() {
        TypeTransaction newType = TypeTransaction.ANNULMENT;
        transaction.setType(newType);
        assertEquals(newType, transaction.getType());
    }

    @Test
    public void testTransactionDateUpdate() {
        Date newTransactionDate = new Date();
        transaction.setTransactionDate(newTransactionDate);
        assertEquals(newTransactionDate, transaction.getTransactionDate());
    }

    @Test
    public void testTransactionTotalAmountUpdate() {
        Integer newTotalAmount = 2000;
        transaction.setTotalAmount(newTotalAmount);
        assertEquals(newTotalAmount, transaction.getTotalAmount());
    }

    @Test
    public void testTransactionIdUpdate() {
        String newTransactionId = "TXN54321";
        transaction.setTransactionId(newTransactionId);
        assertEquals(newTransactionId, transaction.getTransactionId());
    }

    @Test
    public void testTransactionCardNumberUpdate() {
        String newCardNumber = "6543210987654321";
        transaction.setCardNumber(newCardNumber);
        assertEquals(newCardNumber, transaction.getCardNumber());
    }
}

