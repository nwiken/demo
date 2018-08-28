package se.home.service;

import org.springframework.stereotype.Service;
import se.home.dao.PersonRepository;
import se.home.model.entity.Person;

import java.util.List;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> getPersons() {
        return personRepository.findAll();
    }

    public Person getPersonByFirstName(String firstname) {
        return personRepository.findByFirstname(firstname).orElseThrow(() -> new IllegalArgumentException("Finns ej"));
    }

    public Person getPersonById(Long id) {
        return personRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Could not find person with id: " + id));
    }

    public void updatePerson(Long id, Person updatedPerson) {
        Person person = personRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Could not find person with id: " + id));

        person.setLastname(updatedPerson.getLastname());
        person.setAge(updatedPerson.getAge());
        personRepository.save(updatedPerson);
    }

    public void createPerson(Person person) {
        personRepository.save(person);
    }

}
