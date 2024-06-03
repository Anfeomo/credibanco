package com.nexus.credibanco.mappers;

import com.nexus.credibanco.DTO.CardDTO;
import com.nexus.credibanco.model.Card;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-02T21:56:11-0500",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17.0.10 (Oracle Corporation)"
)
public class CardMapperImpl implements CardMapper {

    @Override
    public CardDTO cardToCardDTO(Card card) {
        if ( card == null ) {
            return null;
        }

        CardDTO cardDTO = new CardDTO();

        cardDTO.setId( card.getId() );
        cardDTO.setCurrencyType( card.getCurrencyType() );
        cardDTO.setCardNumber( card.getCardNumber() );
        cardDTO.setProductId( card.getProductId() );
        cardDTO.setHolderName( card.getHolderName() );
        cardDTO.setDueDate( card.getDueDate() );
        cardDTO.setCreationDate( card.getCreationDate() );
        cardDTO.setBalance( card.getBalance() );
        cardDTO.setStatus( card.getStatus() );
        cardDTO.setCardType( card.getCardType() );
        cardDTO.setClient( card.getClient() );

        return cardDTO;
    }

    @Override
    public Card cardDTOToCard(CardDTO cardDTO) {
        if ( cardDTO == null ) {
            return null;
        }

        Card card = new Card();

        card.setId( cardDTO.getId() );
        card.setCardNumber( cardDTO.getCardNumber() );
        card.setProductId( cardDTO.getProductId() );
        card.setHolderName( cardDTO.getHolderName() );
        card.setDueDate( cardDTO.getDueDate() );
        card.setCreationDate( cardDTO.getCreationDate() );
        card.setBalance( cardDTO.getBalance() );
        card.setStatus( cardDTO.getStatus() );
        card.setCardType( cardDTO.getCardType() );
        card.setClient( cardDTO.getClient() );
        card.setCurrencyType( cardDTO.getCurrencyType() );

        return card;
    }
}
