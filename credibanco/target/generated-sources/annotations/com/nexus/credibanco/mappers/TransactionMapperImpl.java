package com.nexus.credibanco.mappers;

import com.nexus.credibanco.DTO.TransactionDTO;
import com.nexus.credibanco.model.Transaction;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-02T21:56:10-0500",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17.0.10 (Oracle Corporation)"
)
public class TransactionMapperImpl implements TransactionMapper {

    @Override
    public TransactionDTO transactionToTransactionDTO(Transaction transaction) {
        if ( transaction == null ) {
            return null;
        }

        TransactionDTO transactionDTO = new TransactionDTO();

        transactionDTO.setId( transaction.getId() );
        transactionDTO.setCardNumber( transaction.getCardNumber() );
        transactionDTO.setType( transaction.getType() );
        transactionDTO.setTransactionId( transaction.getTransactionId() );
        transactionDTO.setAmount( transaction.getAmount() );
        transactionDTO.setTransactionDate( transaction.getTransactionDate() );
        transactionDTO.setTotalAmount( transaction.getTotalAmount() );

        return transactionDTO;
    }

    @Override
    public Transaction transactionDTOToTransaction(TransactionDTO transactionDTO) {
        if ( transactionDTO == null ) {
            return null;
        }

        Transaction transaction = new Transaction();

        transaction.setId( transactionDTO.getId() );
        transaction.setCardNumber( transactionDTO.getCardNumber() );
        transaction.setType( transactionDTO.getType() );
        transaction.setTransactionId( transactionDTO.getTransactionId() );
        transaction.setAmount( transactionDTO.getAmount() );
        transaction.setTransactionDate( transactionDTO.getTransactionDate() );
        transaction.setTotalAmount( transactionDTO.getTotalAmount() );

        return transaction;
    }
}
