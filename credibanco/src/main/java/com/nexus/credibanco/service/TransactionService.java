package com.nexus.credibanco.service;

import com.nexus.credibanco.DTO.PurchaseTransactionDTO;
import com.nexus.credibanco.DTO.TransactionDTO;
import com.nexus.credibanco.mappers.TransactionMapper;
import com.nexus.credibanco.model.Card;
import com.nexus.credibanco.model.Transaction;
import com.nexus.credibanco.model.enums.TypeTransaction;
import com.nexus.credibanco.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TransactionService {
    @Autowired
    TransactionRepository transactionRepository;


    public PurchaseTransactionDTO create(Card card, PurchaseTransactionDTO purchaseTransactionDTO) {
        Transaction newTransaction = new Transaction();
        newTransaction.setTransactionId(card.getProductId());
        newTransaction.setTransactionDate(new Date());
        newTransaction.setCardNumber(purchaseTransactionDTO.getCardNumber());
        newTransaction.setTotalAmount(Integer.parseInt(card.getBalance()) - Integer.parseInt(purchaseTransactionDTO.getPrice()));
        newTransaction.setAmount(Integer.parseInt(purchaseTransactionDTO.getPrice()));
        newTransaction.setType(TypeTransaction.PURCHASE);
        newTransaction.setCard(card);
        transactionRepository.save(newTransaction);
        return purchaseTransactionDTO;
    }

    public TransactionDTO get(String TransactionId) {
        Transaction transaction = transactionRepository.getByTransactionId(TransactionId);
        TransactionDTO transactionDTO = TransactionMapper.INSTANCE.transactionToTransactionDTO(transaction);

        return transactionDTO;
    }
}
