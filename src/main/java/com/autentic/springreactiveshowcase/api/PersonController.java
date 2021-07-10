package com.autentic.springreactiveshowcase.api;

import com.autentic.springreactiveshowcase.application.PersonReactiveService;
import com.autentic.springreactiveshowcase.model.Person;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.CorePublisher;

@RestController
@RequestMapping("/persons")
@RequiredArgsConstructor
public class PersonController {

    @Autowired
    private final PersonReactiveService personService;

    @GetMapping
    public CorePublisher<Person> findAll() {
        return personService.findAll();
    }

    @GetMapping("/{id}")
    public CorePublisher<Person> findById(@PathVariable Long id) {
        return personService.findById(id);
    }

    @PostMapping
    public CorePublisher<Person> save(@RequestBody Person person) {
        return personService.save(person);
    }

    @PutMapping("/{id}")
    public CorePublisher<Person> update(@PathVariable Long id, @RequestBody Person updatedPerson) {
        return personService.findById(id)
                .map(person -> {
                    person.setIdNumber(updatedPerson.getIdNumber());
                    person.setFirstName(updatedPerson.getFirstName());
                    person.setLastName(updatedPerson.getLastName());
                    person.setBirthDate(updatedPerson.getBirthDate());
                    return person;
                })
                .flatMap(personService::save);
    }

    @DeleteMapping("/{id}")
    public CorePublisher<Void> deleteById(@PathVariable Long id) {
        return personService.deleteById(id);
    }
}
