package com.nexus.credibanco.mappers;

import com.nexus.credibanco.DTO.ClientDTO;
import com.nexus.credibanco.model.Client;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-02T21:56:11-0500",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17.0.10 (Oracle Corporation)"
)
public class ClientMapperImpl implements ClientMapper {

    @Override
    public ClientDTO clientToClientDTO(Client client) {
        if ( client == null ) {
            return null;
        }

        ClientDTO clientDTO = new ClientDTO();

        clientDTO.setId( client.getId() );
        clientDTO.setName( client.getName() );
        clientDTO.setLastName( client.getLastName() );
        clientDTO.setRegistrationDate( client.getRegistrationDate() );

        return clientDTO;
    }

    @Override
    public Client clientDTOToClient(ClientDTO clientDTO) {
        if ( clientDTO == null ) {
            return null;
        }

        Client client = new Client();

        client.setId( clientDTO.getId() );
        client.setName( clientDTO.getName() );
        client.setLastName( clientDTO.getLastName() );
        client.setRegistrationDate( clientDTO.getRegistrationDate() );

        return client;
    }
}
