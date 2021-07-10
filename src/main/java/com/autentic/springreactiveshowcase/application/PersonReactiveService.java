package com.autentic.springreactiveshowcase.application;

import com.autentic.springreactiveshowcase.model.Person;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PersonReactiveService {
    Flux<Person> findAll();

    Mono<Person> findById(Long id);

    Mono<Void> deleteById(Long id);

    Mono<Person> save(Person person);

}
