package com.example.demo.mapper;

import com.example.demo.dto.ClientDTO;

import com.example.demo.entity.Client;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ClientMapper {

    public Client clientDTO2Entity(ClientDTO clientDTO){
        Client client = new Client();
        client.setName(clientDTO.getName());
        client.setSurname(clientDTO.getSurname());
        return client;
    }

    public ClientDTO entity2ClientDTO(Client client){
        ClientDTO clientDTO = new ClientDTO();
        clientDTO.setId(client.getId());
        clientDTO.setName(client.getName());
        clientDTO.setSurname(client.getSurname());
        return clientDTO;
    }

    public List<ClientDTO> entity2ClientDTOList(List<Client> clientList){
        List<ClientDTO> clientDTOList = new ArrayList<>();

        for (Client client: clientList){
            clientDTOList.add(entity2ClientDTO(client));
        }

        return clientDTOList;
    }

    public void clientRefreshValues(Client client, ClientDTO clientDTO){
        client.setName(clientDTO.getName());
        client.setSurname(clientDTO.getSurname());
    }


}
