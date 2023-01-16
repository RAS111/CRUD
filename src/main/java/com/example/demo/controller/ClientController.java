package com.example.demo.controller;

import com.example.demo.dto.ClientDTO;
import com.example.demo.service.impl.ClientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientServiceImpl clientService;

    @GetMapping("/")
    public ResponseEntity<List<ClientDTO>> getAll(){
        List<ClientDTO> clientDTOList = this.clientService.getAll();
        return ResponseEntity.ok().body(clientDTOList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientDTO> getClientById(@PathVariable Long id) {
        ClientDTO clientDTO = this.clientService.getById(id);
        return ResponseEntity.ok().body(clientDTO);
    }

    @PostMapping("/")
    public ResponseEntity<ClientDTO> save(@RequestBody ClientDTO clientDTO){
        ClientDTO clientSaved = this.clientService.save(clientDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(clientSaved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClientDTO> update(@PathVariable Long id, @RequestBody ClientDTO clientDTO){
        ClientDTO clientUpdated = this.clientService.update(id, clientDTO);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(clientUpdated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete (@PathVariable Long id){
        this.clientService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
