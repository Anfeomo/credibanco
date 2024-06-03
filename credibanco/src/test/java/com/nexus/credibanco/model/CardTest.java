package com.nexus.credibanco.model;


import com.nexus.credibanco.model.enums.CardType;
import com.nexus.credibanco.model.enums.CurrencyType;
import com.nexus.credibanco.model.enums.Status;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CardTest {

    @Test
    public void testCardModel() {
        // Arrange
        Long id = 1L;
        String productId = "102032";
        String holderName = "pipe herrera";
        Date dueDate = new Date();
        Date creationDate = new Date();
        String balance = "1000";
        Status status = Status.ACTIVE;
        CardType cardType = CardType.CREDIT;

        // Act
        Card card = new Card(id, productId, holderName, dueDate, creationDate, balance, status, cardType);

        // Assert
        assertNotNull(card);
        assertEquals(id, card.getId());
        assertEquals(productId, card.getProductId());
        assertEquals(holderName, card.getHolderName());
        assertEquals(dueDate, card.getDueDate());
        assertEquals(creationDate, card.getCreationDate());
        assertEquals(balance, card.getBalance());
        assertEquals(status, card.getStatus());
        assertEquals(cardType, card.getCardType());
        assertEquals(CurrencyType.USD, card.getCurrencyType());
    }

    @Test
    public void testCardModelEmptyConstructor() {
        // Arrange
        Card card = new Card();

        // Act
        card.setId(1L);
        card.setProductId("102032");
        card.setHolderName("pipe herrera");
        card.setDueDate(new Date());
        card.setCreationDate(new Date());
        card.setBalance("1000");
        card.setStatus(Status.ACTIVE);
        card.setCardType(CardType.CREDIT);
        card.setCurrencyType(CurrencyType.USD);

        // Assert
        assertNotNull(card);
        assertEquals(1L, card.getId());
        assertEquals("102032", card.getProductId());
        assertEquals("pipe herrera", card.getHolderName());
        assertNotNull(card.getDueDate());
        assertNotNull(card.getCreationDate());
        assertEquals("1000", card.getBalance());
        assertEquals(Status.ACTIVE, card.getStatus());
        assertEquals(CardType.CREDIT, card.getCardType());
        assertEquals(CurrencyType.USD, card.getCurrencyType());
    }

    @Test
    public void testCardModelSetClient() {
        // Arrange
        Card card = new Card();
        Client client = new Client();

        // Act
        card.setClient(client);

        // Assert
        assertNotNull(card.getClient());
        assertEquals(client, card.getClient());
    }
}
