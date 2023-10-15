package org.example.person.service;

import org.example.person.mock.PersonMock;
import org.example.person.model.Person;
import org.example.person.request.PersonCreateRequest;
import org.example.person.response.PersonCreateResponse;

import java.util.Random;

public class PersonCreateUseCase {

    private final PersonMock personMock;

    public PersonCreateUseCase() {
        this.personMock = new PersonMock();
    }

    public PersonCreateResponse createPerson(PersonCreateRequest personRequest) {
        Random r = new Random();
        int low = 10;
        int high = 100;
        int result = r.nextInt(high - low) + low;

        Person person = personMock.createPersonMock(result, personRequest.getName(), personRequest.getCpf(), personRequest.getAge());

        PersonCreateResponse personCreateResponse = new PersonCreateResponse();
        personCreateResponse.setId(person.getId());
        personCreateResponse.setName(person.getName());
        personCreateResponse.setCpf(person.getCpf());
        personCreateResponse.setAge(person.getAge());
        personCreateResponse.setCreatedAt(person.getCreatedAt());

        return personCreateResponse;
    }

}
