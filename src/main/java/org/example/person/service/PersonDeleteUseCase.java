package org.example.person.service;

import org.example.person.model.Person;
import org.example.person.request.PersonDeleteRequest;

public class PersonDeleteUseCase {

    public Person getPerson(PersonDeleteRequest personRequest) {
        Person person = new Person();
        person.setId((int) Math.random());


        return person;
    }

}
