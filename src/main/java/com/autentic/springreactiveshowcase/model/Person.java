package com.autentic.springreactiveshowcase.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(value = "persons")
public class Person {
    @Id
    private Long id;
    private Long idNumber;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
}
