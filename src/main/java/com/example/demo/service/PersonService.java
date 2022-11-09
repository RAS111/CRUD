package com.example.demo.service;

import com.example.demo.dto.PersonDTO;

import java.util.List;

public interface PersonService {

    PersonDTO save(PersonDTO personDTO);
    List<PersonDTO> getAll();
    PersonDTO getById(Long id);
    PersonDTO update(Long id, PersonDTO personDTO);
    void delete(Long id);

}
