package com.example.demo.service;

import com.example.demo.dto.ClientDTO;

import java.util.List;

public interface ClientService {

    ClientDTO save(ClientDTO clientDTO);
    List<ClientDTO> getAll();
    ClientDTO getById(Long id);
    ClientDTO update(Long id, ClientDTO clientDTO);
    void delete(Long id);

}
