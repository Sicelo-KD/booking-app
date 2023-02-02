package com.example.sicelo.persistence.repo;

import com.example.sicelo.persistence.model.Person;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PersonRepository extends CrudRepository<Person,Long> {
    Person findPersonByIdNumber(String id);
}
