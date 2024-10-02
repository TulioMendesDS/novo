package com.people.management.api.repository;

import com.people.management.api.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface PersonRepository extends JpaRepository<Person, UUID> {

}
