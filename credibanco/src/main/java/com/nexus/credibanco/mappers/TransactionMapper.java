package com.nexus.credibanco.mappers;

import com.nexus.credibanco.DTO.TransactionDTO;
import com.nexus.credibanco.model.Transaction;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TransactionMapper {
    TransactionMapper INSTANCE = Mappers.getMapper(TransactionMapper.class);

    TransactionDTO transactionToTransactionDTO(Transaction transaction);
    Transaction transactionDTOToTransaction(TransactionDTO transactionDTO);
}