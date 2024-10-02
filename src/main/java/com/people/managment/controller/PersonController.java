package com.people.management.api.controller;

import com.people.management.api.dto.PersonDto;
import com.people.management.api.model.Person;
import com.people.management.api.repository.PersonRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @PostMapping("/persons")
    public ResponseEntity<Person> createPerson(@RequestBody PersonDto personDto){
        Person person = new Person();
        BeanUtils.copyProperties(personDto, person);

        Person savedPerson = personRepository.save(person);

        return ResponseEntity.status(HttpStatus.CREATED).body(savedPerson);
    }

    @GetMapping("/persons")
    public ResponseEntity<List<Person>> getAllPersons(){
        List<Person> allPersons = personRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(allPersons);
    }

    @GetMapping("/persons/{id}")
    public ResponseEntity<Object> getPersonById(@PathVariable UUID id) {
        Optional<Person> foundPerson = personRepository.findById(id);
        if (foundPerson.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Person not found!");
        }
        return ResponseEntity.status(HttpStatus.OK).body(foundPerson.get());
    }

    @DeleteMapping("/persons/{id}")
    public ResponseEntity<String> deletePersonById(@PathVariable UUID id) {
        Optional<Person> foundPerson = personRepository.findById(id);
        if (foundPerson.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Person not found!");
        }
        personRepository.delete(foundPerson.get());
        return ResponseEntity.status(HttpStatus.OK).body("Person deleted successfully!");
    }

    @PutMapping("/persons/{id}")
    public ResponseEntity<Object> updatePersonById(@RequestBody PersonDto personDto,
                                                    @PathVariable UUID id){
        Optional<Person> foundPerson = personRepository.findById(id);
        if(foundPerson.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Person not found!");
        }

        Person person = foundPerson.get();
        BeanUtils.copyProperties(personDto, person);
        return ResponseEntity.status(HttpStatus.OK).body(personRepository.save(person));
    }
}
