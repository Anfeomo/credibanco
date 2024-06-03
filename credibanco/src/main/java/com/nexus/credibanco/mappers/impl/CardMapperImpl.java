package com.nexus.credibanco.mappers.impl;

import com.nexus.credibanco.DTO.CardDTO;
import com.nexus.credibanco.mappers.CardMapper;
import com.nexus.credibanco.model.Card;

public class CardMapperImpl implements CardMapper {
    @Override
    public CardDTO cardToCardDTO(Card card) {
        CardDTO cardDTO = new CardDTO();
        cardDTO.setId(card.getId());
        cardDTO.setCardNumber(card.getCardNumber());
        cardDTO.setProductId(card.getProductId());
        cardDTO.setHolderName(card.getHolderName());
        cardDTO.setClient(card.getClient());
        return cardDTO;
    }

    @Override
    public Card cardDTOToCard(CardDTO cardDTO) {
        Card card = new Card();
        card.setId(cardDTO.getId());
        card.setCardNumber(cardDTO.getCardNumber());
        card.setProductId(cardDTO.getProductId());
        card.setHolderName(cardDTO.getHolderName());
        card.setClient(cardDTO.getClient());
        return card;
    }
}

