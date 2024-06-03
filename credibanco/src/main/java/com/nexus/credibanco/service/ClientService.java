package com.nexus.credibanco.service;

import com.nexus.credibanco.DTO.ClientDTO;
import com.nexus.credibanco.mappers.ClientMapper;
import com.nexus.credibanco.model.Client;
import com.nexus.credibanco.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    ClientRepository clienteRepository;

    public List<Client> getAll(){
        return (List<Client>) clienteRepository.findAll();
    }

    public Optional<Client> getById(Long id){
        return  clienteRepository.findById(id);
    }

    public Client create(ClientDTO newClientDTO)  {
        Client client = ClientMapper.INSTANCE.clientDTOToClient(newClientDTO);
        return clienteRepository.save(client);
    }

    public Client update(ClientDTO clientDTO){
        Client client = ClientMapper.INSTANCE.clientDTOToClient(clientDTO);
        if (clienteRepository.existsById(client.getId())){
           return clienteRepository.save(client);
        }
        return new Client();
    }

    public String delete(Long id){
        if(clienteRepository.existsById(id)){
            clienteRepository.deleteById(id);
              return "Client deleted";
        }
        return "Client does not exits";

    }

}
