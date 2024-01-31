package com.realworld.service;

import com.realworld.model.Person;
import com.realworld.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    private PersonRepository personRepository;

    public Person savePerson(Person person) {
        // Exception??
        return personRepository.save(person);
    }

    public List<Person> getAllPerson() {
        return personRepository.findAll();
    }

    public List< Person > getByName(String name) {
        return personRepository.getByName(name);
    }

    public Optional< Person > getById(Long id) {
        return personRepository.findById(id);
    }

    public void deleteById(Long id) {
        personRepository.deleteById(id);
    }
}
