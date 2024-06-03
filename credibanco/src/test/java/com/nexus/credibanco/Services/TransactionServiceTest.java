package com.nexus.credibanco.Services;

import com.nexus.credibanco.DTO.PurchaseTransactionDTO;
import com.nexus.credibanco.DTO.TransactionDTO;
import com.nexus.credibanco.mappers.impl.TransactionMapperImpl;
import com.nexus.credibanco.model.Card;
import com.nexus.credibanco.model.Transaction;
import com.nexus.credibanco.model.enums.TypeTransaction;
import com.nexus.credibanco.repository.TransactionRepository;
import com.nexus.credibanco.service.TransactionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

public class TransactionServiceTest {

    @InjectMocks
    private TransactionService transactionService;

    @Mock
    private TransactionRepository transactionRepository;

    @InjectMocks
    private TransactionMapperImpl transactionMapperImpl;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);


    }

    @Test
    public void testCreateTransaction() {
        Card card = new Card();
        card.setProductId("123456");
        card.setBalance("1000");

        PurchaseTransactionDTO purchaseTransactionDTO = new PurchaseTransactionDTO();
        purchaseTransactionDTO.setCardNumber("1234567890123456");
        purchaseTransactionDTO.setPrice("100");

        Transaction newTransaction = new Transaction();
        newTransaction.setTransactionId("123456");
        newTransaction.setTransactionDate(new Date());
        newTransaction.setCardNumber("1234567890123456");
        newTransaction.setTotalAmount(900);
        newTransaction.setAmount(100);
        newTransaction.setType(TypeTransaction.PURCHASE);
        newTransaction.setCard(card);

        when(transactionRepository.save(any(Transaction.class))).thenReturn(newTransaction);

        PurchaseTransactionDTO result = transactionService.create(card, purchaseTransactionDTO);

        assertNotNull(result);
        assertEquals(purchaseTransactionDTO.getCardNumber(), result.getCardNumber());
        assertEquals(purchaseTransactionDTO.getPrice(), result.getPrice());

        verify(transactionRepository, times(1)).save(any(Transaction.class));
    }

    @Test
    public void testGetTransaction() {
        String transactionId = "TXN12345";
        Transaction transaction = new Transaction();
        transaction.setTransactionId(transactionId);

        TransactionDTO transactionDTO = new TransactionDTO();
        transactionDTO.setTransactionId(transactionId);

        when(transactionRepository.getByTransactionId(transactionId)).thenReturn(transaction);
        when(transactionMapperImpl.transactionToTransactionDTO(transaction)).thenReturn(transactionDTO);

        TransactionDTO result = transactionService.get(transactionId);

        assertNotNull(result);
        assertEquals(transactionId, result.getTransactionId());

        verify(transactionRepository, times(1)).getByTransactionId(transactionId);
        verify(transactionMapperImpl, times(1)).transactionToTransactionDTO(transaction);
    }
}

