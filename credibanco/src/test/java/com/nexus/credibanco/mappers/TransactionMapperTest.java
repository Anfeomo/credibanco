package com.nexus.credibanco.mappers;

import com.nexus.credibanco.DTO.TransactionDTO;
import com.nexus.credibanco.model.Transaction;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TransactionMapperTest {

    @Test
    public void testTransactionToTransactionDTO() {
        Transaction transaction = new Transaction();
        transaction.setId(1L);

        TransactionDTO transactionDTO = TransactionMapper.INSTANCE.transactionToTransactionDTO(transaction);


        assertEquals(transaction.getId(), transactionDTO.getId());

    }

    @Test
    public void testTransactionDTOToTransaction() {
        TransactionDTO transactionDTO = new TransactionDTO();
        transactionDTO.setId(1L);
        Transaction transaction = TransactionMapper.INSTANCE.transactionDTOToTransaction(transactionDTO);

        assertEquals(transactionDTO.getId(), transaction.getId());
    }
}

