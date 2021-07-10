package com.autentic.springreactiveshowcase.persistence;

import com.autentic.springreactiveshowcase.model.Person;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

public interface PersonRepository extends R2dbcRepository<Person, Long> {
}
