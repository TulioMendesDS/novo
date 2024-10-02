package com.people.management.api.model;


import jakarta.persistence.*;
import lombok.Data;
import lombok.Generated;

import java.util.UUID;

@Entity
@Table(name = "person_db")
@Data
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String name;

    private String cpf;

    private int idade;

}
