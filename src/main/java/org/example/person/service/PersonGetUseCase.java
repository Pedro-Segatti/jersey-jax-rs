package org.example.person.service;

import org.example.person.mock.PersonMock;
import org.example.person.model.Person;
import org.example.person.response.PersonGetResponse;

import java.util.ArrayList;
import java.util.List;

public class PersonGetUseCase {

    private final PersonMock personMock;

    public PersonGetUseCase() {
        this.personMock = new PersonMock();
    }

    public List<PersonGetResponse> getPerson() {
        List<PersonGetResponse> personGetResponseList = new ArrayList<PersonGetResponse>();

        for (Person person : this.personMock.getMockedPersons()) {
            PersonGetResponse personGetResponse = new PersonGetResponse();
            personGetResponse.setId(person.getId());
            personGetResponse.setName(person.getName());
            personGetResponse.setCpf(person.getCpf());
            personGetResponse.setAge(person.getAge());
            personGetResponse.setCreatedAt(person.getCreatedAt());
            personGetResponse.setUpdatedAt(person.getUpdatedAt());
            personGetResponseList.add(personGetResponse);
        }
        return personGetResponseList;
    }
}
