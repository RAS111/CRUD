package com.example.demo.service.impl;

import com.example.demo.dto.PersonDTO;
import com.example.demo.entity.Person;
import com.example.demo.mapper.PersonMapper;
import com.example.demo.repository.PersonRepository;
import com.example.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private PersonMapper personMapper;

    @Override
    public PersonDTO save(PersonDTO personDTO) {
        Person person = this.personMapper.personDTO2Entity(personDTO);
        Person personSaved = this.personRepository.save(person);
        PersonDTO result = this.personMapper.entity2PersonDTO(personSaved);
        return result;

    }

    @Override
    public List<PersonDTO> getAll() {
        List<Person> personList = this.personRepository.findAll();
        List<PersonDTO> result = this.personMapper.entity2PersonDTOList(personList);
        return result;
    }

    @Override
    public PersonDTO getById(Long id) {
        Optional<Person> personOptional = this.personRepository.findById(id);
        PersonDTO result = this.personMapper.entity2PersonDTO(personOptional.get());
        return result;
    }

    @Override
    public PersonDTO update(Long id, PersonDTO personDTO) {
        Optional<Person> personOptional = this.personRepository.findById(id);

        this.personMapper.personRefreshValues(personOptional.get(), personDTO);
        Person personSaved = this.personRepository.save(personOptional.get());
        PersonDTO result = this.personMapper.entity2PersonDTO(personSaved);

        return result;

    }

    @Override
    public void delete(Long id) {
        this.personRepository.deleteById(id);
    }
}
