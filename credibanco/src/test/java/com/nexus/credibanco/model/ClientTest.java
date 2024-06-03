package com.nexus.credibanco.model;


import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ClientTest {

    @Test
    public void testClientModel() {
        // Arrange
        Long id = 1L;
        String name = "pipe";
        String lastName = "jose";
        Date registrationDate = new Date();

        // Act
        Client client = new Client(id, name, lastName, registrationDate);

        // Assert
        assertNotNull(client);
        assertEquals(id, client.getId());
        assertEquals(name, client.getName());
        assertEquals(lastName, client.getLastName());
        assertEquals(registrationDate, client.getRegistrationDate());
    }

    @Test
    public void testClientModelEmptyConstructor() {
        // Arrange
        Client client = new Client();

        // Act
        client.setId(1L);
        client.setName("pipe");
        client.setLastName("jose");
        client.setRegistrationDate(new Date());

        // Assert
        assertNotNull(client);
        assertEquals(1L, client.getId());
        assertEquals("pipe", client.getName());
        assertEquals("jose", client.getLastName());
        assertNotNull(client.getRegistrationDate());
    }


}

