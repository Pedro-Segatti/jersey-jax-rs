package org.example.person.service;

import org.example.person.mock.PersonMock;
import org.example.person.model.Person;
import org.example.person.request.PersonGetRequest;
import org.example.person.response.PersonGetResponse;

import java.util.Optional;

public class PersonGetUseCase {

    private PersonMock personMock;

    public PersonGetUseCase() {
        this.personMock = new PersonMock();
    }

    public PersonGetResponse getPerson(PersonGetRequest personRequest) {
        Optional<Person> foundPerson = this.personMock.getMockedPersons()
                .stream()
                .filter(person -> person.getId().equals(personRequest.getId()))
                .findFirst();

        PersonGetResponse personGetResponse = new PersonGetResponse();
        if (foundPerson.isPresent()) {
            personGetResponse.setId(foundPerson.get().getId());
            personGetResponse.setName(foundPerson.get().getName());
            personGetResponse.setCpf(foundPerson.get().getCpf());
            personGetResponse.setAge(foundPerson.get().getAge);
        }


        return person;
    }

}
