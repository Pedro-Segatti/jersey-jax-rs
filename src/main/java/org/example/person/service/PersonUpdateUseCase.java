package org.example.person.service;

import org.example.person.model.Person;
import org.example.person.request.PersonCreateRequest;

public class PersonUpdateUseCase {

    public Person updatePerson(PersonCreateRequest personRequest) {
        Person person = new Person();
        person.setId((int) Math.random());
        person.setName(personRequest.getName());
        person.setCpf(personRequest.getCpf());
        person.setAge(personRequest.getAge());

        return person;
    }

}
