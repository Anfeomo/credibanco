package com.nexus.credibanco.controller;


import com.nexus.credibanco.DTO.ClientDTO;
import com.nexus.credibanco.mappers.ClientMapper;
import com.nexus.credibanco.model.Client;
import com.nexus.credibanco.service.ClientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {
    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/")
    public List<Client> getAllClient() {
        return clientService.getAll();
    }

    @PostMapping("/")
    public Client createClient(@RequestBody ClientDTO newClientDTO)  {
        return clientService.create(newClientDTO);
    }

    @PutMapping("/")
    public Client updateClient(@RequestBody ClientDTO updateClientDTO){

        return clientService.update(updateClientDTO);
    }

    @DeleteMapping(value = "/id/{idClient}")
    public void deleteClient(@PathVariable Long idClient){
        clientService.delete(idClient);
    }

}
