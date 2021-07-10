package com.autentic.springreactiveshowcase.application;

import com.autentic.springreactiveshowcase.model.Person;
import com.autentic.springreactiveshowcase.persistence.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class DomainPersonService implements PersonReactiveService {
    @Autowired
    private final PersonRepository personRepository;

    @Override
    public Flux<Person> findAll() {
        return personRepository.findAll();
    }

    @Override
    public Mono<Person> findById(Long id) {
        return personRepository.findById(id);
    }

    @Override
    public Mono<Void> deleteById(Long id) {
        return personRepository.deleteById(id);
    }

    @Override
    public Mono<Person> save(Person person) {
        return personRepository.save(person);
    }
}
