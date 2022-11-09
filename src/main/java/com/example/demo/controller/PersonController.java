package com.example.demo.controller;

import com.example.demo.dto.PersonDTO;
import com.example.demo.service.impl.PersonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonServiceImpl personService;

    @GetMapping("/")
    public ResponseEntity<List<PersonDTO>> getAllPerson(){
        List<PersonDTO> personDTOList = this.personService.getAll();
        return ResponseEntity.ok().body(personDTOList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonDTO> getPersonById(@PathVariable Long id) {
        PersonDTO personDTO = this.personService.getById(id);
        return ResponseEntity.ok().body(personDTO);
    }

    @PostMapping("/")
    public ResponseEntity<PersonDTO> save(@RequestBody PersonDTO personDTO){
        PersonDTO personSaved = this.personService.save(personDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(personSaved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PersonDTO> update(@PathVariable Long id, @RequestBody PersonDTO personDTO){
        PersonDTO personUpdated = this.personService.update(id, personDTO);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(personUpdated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete (@PathVariable Long id){
        this.personService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
