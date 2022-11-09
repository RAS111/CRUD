package com.example.demo.mapper;

import com.example.demo.dto.PersonDTO;
import com.example.demo.entity.Person;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonMapper {

    public Person personDTO2Entity(PersonDTO personDTO){
        Person person = new Person();
        person.setName(personDTO.getName());
        person.setSurname(personDTO.getSurname());
        return person;
    }

    public PersonDTO entity2PersonDTO(Person person){
        PersonDTO personDTO = new PersonDTO();
        personDTO.setId(person.getId());
        personDTO.setName(person.getName());
        personDTO.setSurname(person.getSurname());
        return personDTO;
    }

    public List<PersonDTO> entity2PersonDTOList(List<Person> personList){
        List<PersonDTO> personDTOList = new ArrayList<>();

        for (Person person: personList){
            personDTOList.add(entity2PersonDTO(person));
        }

        return personDTOList;
    }

    public void personRefreshValues(Person person, PersonDTO personDTO){
        person.setName(personDTO.getName());
        person.setSurname(personDTO.getSurname());
    }


}
