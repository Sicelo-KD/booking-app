package com.example.sicelo.service;

import com.example.sicelo.persistence.model.Person;
import com.example.sicelo.persistence.repo.PersonRepository;
import com.example.sicelo.web.exception.PersonNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public Person findPersonByIdNumber(String idNumber) {
        return personRepository.findPersonByIdNumber(idNumber);
    }

    public Person findOne(long id){
        return personRepository.findById(id).
                orElseThrow(PersonNotFoundException::new);
    }

    public Person create(Person person){
        return personRepository.save(person);
    }


    public void deleteOne(long id){
        personRepository.findById(id).orElseThrow(PersonNotFoundException::new);
        personRepository.deleteById(id);
    }

    public Person updatePerson(Person person, long id){
        if(person.getId() != id) {
            throw new PersonNotFoundException("No such Person Exists");
        }
        personRepository.findById(id).orElseThrow(PersonNotFoundException::new);
        return personRepository.save(person);
    }
}