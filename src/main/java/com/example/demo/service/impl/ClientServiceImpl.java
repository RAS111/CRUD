package com.example.demo.service.impl;

import com.example.demo.dto.ClientDTO;
import com.example.demo.entity.Client;
import com.example.demo.mapper.ClientMapper;
import com.example.demo.repository.ClientRepository;
import com.example.demo.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ClientMapper clientMapper;

    @Override
    public ClientDTO save(ClientDTO clientDTO) {
        Client client = this.clientMapper.clientDTO2Entity(clientDTO);
        Client clientSaved = this.clientRepository.save(client);
        ClientDTO result = this.clientMapper.entity2ClientDTO(clientSaved);
        return result;

    }

    @Override
    public List<ClientDTO> getAll() {
        List<Client> clientList = this.clientRepository.findAll();
        List<ClientDTO> result = this.clientMapper.entity2ClientDTOList(clientList);
        return result;
    }

    @Override
    public ClientDTO getById(Long id) {
        Optional<Client> clientOptional = this.clientRepository.findById(id);
        ClientDTO result = this.clientMapper.entity2ClientDTO(clientOptional.get());
        return result;
    }

    @Override
    public ClientDTO update(Long id, ClientDTO clientDTO) {
        Optional<Client> clientOptional = this.clientRepository.findById(id);

        this.clientMapper.clientRefreshValues(clientOptional.get(), clientDTO);
        Client clientSaved = this.clientRepository.save(clientOptional.get());
        ClientDTO result = this.clientMapper.entity2ClientDTO(clientSaved);

        return result;

    }

    @Override
    public void delete(Long id) {
        this.clientRepository.deleteById(id);
    }
}
