package com.nexus.credibanco.controller;

import com.nexus.credibanco.DTO.PurchaseTransactionDTO;
import com.nexus.credibanco.DTO.TransactionDTO;
import com.nexus.credibanco.model.Card;
import com.nexus.credibanco.service.CardService;
import com.nexus.credibanco.service.TransactionService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transactions")
public class TransactionController {
    private final TransactionService transactionService;

    private final CardService cardService;

    public TransactionController(TransactionService transactionService, CardService cardService) {
        this.transactionService = transactionService;
        this.cardService = cardService;
    }

    @PostMapping("/transaction/purcharse/card/{cardNumber}")
    public PurchaseTransactionDTO createTransaction(@PathVariable String cardNumber,  @RequestBody PurchaseTransactionDTO purchaseTransactionDTO){
        Card card = cardService.getCardNumber(cardNumber);
      return  transactionService.create(card,purchaseTransactionDTO);
    }

    @GetMapping("/transaction/{transactionId}")
    public TransactionDTO getTransaction(@PathVariable String transactionId){
        return transactionService.get(transactionId);
    }
}
