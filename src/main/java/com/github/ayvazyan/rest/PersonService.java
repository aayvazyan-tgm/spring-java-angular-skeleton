package com.github.ayvazyan.rest;

import org.springframework.stereotype.Controller;

@Controller
public class PersonService {
    private Person storedPerson;

    public void storePerson(Person person) {
        storedPerson = person;
    }

    public Person getStoredPerson() {
        return storedPerson;
    }
}
