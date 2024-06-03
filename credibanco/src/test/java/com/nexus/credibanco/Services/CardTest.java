package com.nexus.credibanco.Services;

import com.nexus.credibanco.DTO.CardBalanceDTO;
import com.nexus.credibanco.DTO.CardDTO;
import com.nexus.credibanco.mappers.CardMapper;
import com.nexus.credibanco.mappers.impl.CardMapperImpl;
import com.nexus.credibanco.model.Card;
import com.nexus.credibanco.model.Client;
import com.nexus.credibanco.model.enums.Status;
import com.nexus.credibanco.repository.CardRepository;
import com.nexus.credibanco.service.CardService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

class CardServiceTest {

    @InjectMocks
    private CardService cardService;

    @Mock
    private CardRepository cardRepository;


    private CardMapperImpl CardMapperImpl = new CardMapperImpl();

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);

    }

    @Test
    void testGetAll() {
        List<Card> cards = List.of(new Card(), new Card());
        when(cardRepository.findAll()).thenReturn(cards);

        List<Card> result = cardService.getAll();

        assertEquals(cards.size(), result.size());
        verify(cardRepository, times(1)).findAll();
    }

    @Test
    void testCreate() {
        // Arrange
        CardDTO newCardDTO = new CardDTO();
        newCardDTO.setProductId("123456");
        Client client = new Client();
        client.setName("John");
        client.setLastName("Doe");

        Card card = new Card();
        card.setProductId(newCardDTO.getProductId());
        card.setClient(client);

        // Act
        Card result = cardService.create(newCardDTO, client);

        // Assert
        assertNotNull(result);
        assertEquals(newCardDTO.getProductId(), result.getProductId());
        assertEquals(client, result.getClient());
        verify(cardRepository, times(1)).save(result);
    }



    @Test
    void testDelete() {
        Long id = 1L;

        cardService.delete(id);

        verify(cardRepository, times(1)).deleteById(id);
    }

    @Test
    void testActivateCard() {
        String cardNumber = "1234567890123456";
        Card testCard = new Card();
        testCard.setCardNumber(cardNumber);
        testCard.setStatus(Status.INACTIVE);

        // Crear una lista que contenga solo el testCard
        List<Card> cardList = Collections.singletonList(testCard);

        // Configurar el comportamiento de cardRepository.findAll()
        when(cardRepository.findAll()).thenReturn(cardList);

        // Llamar al método que quieres probar
        String result = cardService.enrollCard(cardNumber);

        // Verificar que el resultado sea el esperado
        assertEquals(cardNumber, result);
        assertEquals(Status.ACTIVE, testCard.getStatus());
        verify(cardRepository, times(1)).save(testCard);
    }




    @Test
    void testLockCard() {
        String cardNumber = "1234567890123456";
        Card card = new Card();
        card.setCardNumber(cardNumber);
        card.setStatus(Status.ACTIVE);

        List<Card> cardList = Collections.singletonList(card);

        when(cardRepository.findAll()).thenReturn(cardList);

        String result = cardService.lockCard(cardNumber);
        assertEquals(cardNumber, result);
        assertEquals(Status.LOCKED, card.getStatus());
        verify(cardRepository, times(1)).save(card);
    }


    @Test
    void testRechargeCard() {
        String cardNumber = "1234567890123456";
        BigDecimal newBalance = new BigDecimal("100.00");
        CardBalanceDTO cardBalanceDTO = new CardBalanceDTO();
        cardBalanceDTO.setNumberCard(cardNumber);
        cardBalanceDTO.setBalance(newBalance.toString()); // Convertir el BigDecimal a String

        Card card = new Card();
        card.setCardNumber(cardNumber);
        card.setBalance("0"); // Establecer el saldo como String

        when(cardRepository.findAll()).thenReturn(Collections.singletonList(card));

        CardBalanceDTO result = cardService.rechargeCard(cardBalanceDTO);

        assertEquals(cardBalanceDTO.getNumberCard(), result.getNumberCard());
        assertEquals(newBalance, new BigDecimal(result.getBalance())); // Convertir el String a BigDecimal para comparar
        assertEquals(newBalance, new BigDecimal(card.getBalance())); // Convertir el String a BigDecimal para comparar
        verify(cardRepository, times(1)).save(card);
    }




    @Test
    void testGetBalance() {
        String cardNumber = "1234567890123456";
        String balance = "100.00";

        Card card = new Card();
        card.setCardNumber(cardNumber);
        card.setBalance(balance);

        when(cardRepository.findAll()).thenReturn(Collections.singletonList(card));

        String result = cardService.getBalance(cardNumber);

        assertEquals(balance, result);
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

