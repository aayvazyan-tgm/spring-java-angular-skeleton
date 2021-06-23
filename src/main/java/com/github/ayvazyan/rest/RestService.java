package com.github.ayvazyan.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class RestService {

    private final PersonService personService;

    public RestService(@Autowired PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("hello/{name}")
    public ResponseEntity<String> getHello(@PathVariable String name) {
        return new ResponseEntity<>("Hello " + name, HttpStatus.OK);
    }

    @PostMapping("store")
    public ResponseEntity<String> goodbye(@RequestBody Person person) {
        this.personService.storePerson(person);
        return new ResponseEntity<>("Stored " + person.getName(), HttpStatus.OK);
    }
}

class Person {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}