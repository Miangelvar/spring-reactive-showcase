package com.autentic.springreactiveshowcase;

import com.autentic.springreactiveshowcase.model.Person;
import com.autentic.springreactiveshowcase.persistence.PersonRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

@Component
@RequiredArgsConstructor
@Log4j2
public class SampleDataInitializer {
    private final PersonRepository personRepository;

    @EventListener(ApplicationReadyEvent.class)
    public void initialize() {
        var savedPersons = Flux.just("Peter", "Josh", "Miguel", "Andrea", "Daniel", "Alexa")
                .map(name -> Person.builder().firstName(name).build())
                .flatMap(personRepository::save);

        personRepository
                .deleteAll()
                .thenMany(savedPersons)
                .thenMany(this.personRepository.findAll())
                .subscribe(log::info);
    }
}
