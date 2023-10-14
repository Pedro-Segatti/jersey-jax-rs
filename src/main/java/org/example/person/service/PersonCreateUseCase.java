package org.example.person.service;

import org.example.person.mock.PersonMock;
import org.example.person.model.Person;
import org.example.person.request.PersonCreateRequest;
import org.example.person.response.PersonCreateResponse;

public class PersonCreateUseCase {

    private PersonMock personMock;

    public PersonCreateUseCase() {
        this.personMock = new PersonMock();
    }

    public PersonCreateResponse createPerson(PersonCreateRequest personRequest) {
        Person person = personMock.createPersonMock((int)Math.random(), personRequest.getName(), personRequest.getCpf(), personRequest.getAge());

        PersonCreateResponse personCreateResponse = new PersonCreateResponse();
        personCreateResponse.setId(person.getId());
        personCreateResponse.setName(person.getName());
        personCreateResponse.setCpf(person.getCpf());
        personCreateResponse.setAge(person.getAge());
        personCreateResponse.setCreatedAt(person.getCreatedAt());

        return personCreateResponse;
    }

}
