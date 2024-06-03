package com.nexus.credibanco.service;

import com.nexus.credibanco.DTO.CardBalanceDTO;
import com.nexus.credibanco.DTO.CardDTO;
import com.nexus.credibanco.mappers.CardMapper;
import com.nexus.credibanco.model.Card;
import com.nexus.credibanco.model.Client;
import com.nexus.credibanco.model.enums.Status;
import com.nexus.credibanco.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class CardService {

    @Autowired
    CardRepository cardRepository;
    private CardMapper cardMapper;

    public List<Card> getAll() {
        return (List<Card>) cardRepository.findAll();
    }

    public Card getCardByproductId(String productId) {
        Card card = cardRepository.findAll()
                .stream()
                .filter(c -> productId.equals(c.getProductId()))
                .findFirst()
                .orElse(null);
        return card;
    }

    public Card getCardNumber(String cardNumber) {
        return (Card) cardRepository.findAll()
                .stream()
                .filter(card -> cardNumber.equals(card.getCardNumber()))
                .map(cardMapper::cardToCardDTO)
                .collect(Collectors.toList());
    }

    public Card create(CardDTO newCardDTO, Client client) {
        String randomDigits = generateNumberCard(10);
        String cardNumber = String.format("%06d%s", Integer.parseInt(newCardDTO.getProductId()), randomDigits);
        newCardDTO.setCreationDate(new Date());
        newCardDTO.setDueDate(new Date());
        newCardDTO.setCardNumber(cardNumber);
        newCardDTO.setStatus(Status.INACTIVE);
        newCardDTO.setHolderName(client.getName().split(" ")[0] + " " + client.getLastName());

        Card card = CardMapper.INSTANCE.cardDTOToCard(newCardDTO);
        card.setClient(client);

        return cardRepository.save(card);
    }



    public void delete(Long id) {
        cardRepository.deleteById(id);
    }


    public String enrollCard(String cardNumber) {
        Card enrollcard = cardRepository.findAll()
                .stream()
                .filter(c -> cardNumber.equals(c.getCardNumber()))
                .findFirst()
                .orElse(null);
        if (enrollcard != null) {
            enrollcard.setStatus(Status.ACTIVE);
            cardRepository.save(enrollcard);
            return enrollcard.getCardNumber();
        } else {
            return "card does not exist.";
        }
    }

    public String lockCard(String cardNumber) {
        Card lockCard = (cardRepository.findAll()
                .stream()
                .filter(c -> cardNumber.equals(c.getCardNumber()))
                .findFirst()
                .orElse(null));
        if (lockCard != null) {
            lockCard.setStatus(Status.LOCKED);
            cardRepository.save(lockCard);
            return lockCard.getCardNumber();
        } else {
            return "Card does not exist.";
        }
    }

    public CardBalanceDTO rechargeCard(CardBalanceDTO cardBalanceDTO) {
        Card rechargeCard = cardRepository.findAll()
                .stream()
                .filter(c -> cardBalanceDTO.getNumberCard().equals(c.getCardNumber()))
                .findFirst()
                .orElse(null);
        if (rechargeCard != null) {
            rechargeCard.setBalance(cardBalanceDTO.getBalance());
            cardRepository.save(rechargeCard);
            return cardBalanceDTO;
        }
        return new CardBalanceDTO();
    }

    public String getBalance(String cardNumber) {
        Card BalanceCard = (cardRepository.findAll()
                .stream()
                .filter(c -> cardNumber.equals(c.getCardNumber()))
                .findFirst()
                .orElse(null));
        if (BalanceCard != null) {
            return BalanceCard.getBalance();
        } else {
            return "Number card does not exist.";
        }
    }

    private String generateNumberCard(int length) {
        Random random = new Random();
        StringBuilder builder = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            builder.append(random.nextInt(10));
        }
        return builder.toString();
    }
}
