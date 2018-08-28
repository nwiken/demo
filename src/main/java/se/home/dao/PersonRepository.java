package se.home.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import se.home.model.entity.Person;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {

    List<Person> findAll();

    Optional<Person> findByFirstname(String firstname);

    Optional<Person> findByLastname(String lastname);

}
