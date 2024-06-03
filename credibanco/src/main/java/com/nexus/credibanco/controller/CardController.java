package com.nexus.credibanco.controller;

import com.nexus.credibanco.DTO.CardBalanceDTO;
import com.nexus.credibanco.DTO.CardDTO;
import com.nexus.credibanco.Exception.ClientNotFoundException;
import com.nexus.credibanco.model.Card;
import com.nexus.credibanco.model.Client;
import com.nexus.credibanco.service.CardService;
import com.nexus.credibanco.service.ClientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("cards")
public class CardController {

    private final CardService cardService;
    private final ClientService clientService;

    public CardController(CardService cardService, ClientService clientService) {
        this.cardService = cardService;
        this.clientService = clientService;
    }


    @GetMapping("/")
    public List<Card> getAllCard() {
        return cardService.getAll();
    }

    @GetMapping("/card/{productId}/number")
    public Card getCardNumber(@PathVariable String productId) {
        return cardService.getCardByproductId(productId);
    }

    @PostMapping("/idClient/{idClient}")
    public Card createCard(@PathVariable long idClient, @RequestBody CardDTO newCardDTO) {
        Optional<Client> clientOptional = clientService.getById(idClient);
        if (clientOptional.isPresent()) {
            Client client = clientOptional.get();
            return cardService.create(newCardDTO, client);
        } else {
            throw new ClientNotFoundException("Client not found with id: " + idClient);
        }
    }

    @PostMapping("/card/{cardNumber}/enroll")
    public String activateCard(@PathVariable String cardNumber) {
        return cardService.enrollCard(cardNumber);
    }

    @DeleteMapping("/card/{cardNumber}")
    public String lockCard(@PathVariable String cardNumber) {
        String result = cardService.lockCard(cardNumber);
        return result;
    }

    @PostMapping("/card/balance")
    public CardBalanceDTO rechargeCard(@RequestBody CardBalanceDTO cardBalanceDTO) {
        return cardService.rechargeCard(cardBalanceDTO);
    }

    @GetMapping("/card/balance/{cardNumber}")
    public String getBalance(@PathVariable String cardNumber) {
        return cardService.getBalance(cardNumber);
    }



    @DeleteMapping(value = "/id/", params = "id")
    public void deleteCard(@RequestParam Long id) {
        cardService.delete(id);
    }
}
