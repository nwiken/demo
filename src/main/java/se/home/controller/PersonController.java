package se.home.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import se.home.model.entity.Person;
import se.home.service.PersonService;

import java.util.List;

@RestController
public class PersonController {

    private final PersonService personService;

    private static final Logger LOGGER = LoggerFactory.getLogger(PersonController.class);

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @RequestMapping(path = "/person",
            method = RequestMethod.GET)
    public List<Person> getPersons() {
        LOGGER.info("Calling getPersons");
        return personService.getPersons();
    }

    @RequestMapping(path = "/person/{id}",
            method = RequestMethod.GET)
    public Person getPerson(@PathVariable Long id) {
        return personService.getPersonById(id);
    }

    @RequestMapping(path = "/person/{id}",
            method = RequestMethod.PUT)
    public void updatePerson(@PathVariable Long id, Person person) {
        LOGGER.info("Updating person with id: {}", id);
        personService.updatePerson(id, person);
    }

    @RequestMapping(path = "/person",
            consumes = "application/json",
            method = RequestMethod.POST)
    public void createPerson(Person person) {

        personService.createPerson(person);
    }

    @RequestMapping(path = "/person/firstname/{firstname}",
            method = RequestMethod.GET)
    public Person getPersonByFirstName(@PathVariable String firstname) {
        return personService.getPersonByFirstName(firstname);
    }

}
