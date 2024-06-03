package com.nexus.credibanco.mappers.impl;

import com.nexus.credibanco.DTO.TransactionDTO;
import com.nexus.credibanco.mappers.TransactionMapper;
import com.nexus.credibanco.model.Transaction;

public class TransactionMapperImpl implements TransactionMapper {
    @Override
    public TransactionDTO transactionToTransactionDTO(Transaction transaction) {
        if (transaction == null) {
            return null;
        }

        TransactionDTO transactionDTO = new TransactionDTO();
        transactionDTO.setTransactionId(transaction.getTransactionId());
        transactionDTO.setCardNumber(transaction.getCardNumber());
        transactionDTO.setType(transaction.getType());
        transactionDTO.setAmount(transaction.getAmount());
        transactionDTO.setTransactionDate(transaction.getTransactionDate());
        transactionDTO.setTotalAmount(transaction.getTotalAmount());
        return transactionDTO;
    }

    @Override
    public Transaction transactionDTOToTransaction(TransactionDTO transactionDTO) {
        if (transactionDTO == null) {
            return null;
        }

        Transaction transaction = new Transaction();
        transaction.setTransactionId(transactionDTO.getTransactionId());
        transaction.setCardNumber(transactionDTO.getCardNumber());
        transaction.setType(transactionDTO.getType());
        transaction.setAmount(transactionDTO.getAmount());
        transaction.setTransactionDate(transactionDTO.getTransactionDate());
        transaction.setTotalAmount(transactionDTO.getTotalAmount());
        return transaction;
    }
}
