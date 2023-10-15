package org.example.person.service;

import org.example.person.mock.PersonMock;
import org.example.person.model.Person;
import org.example.person.request.PersonUpdateRequest;
import org.example.person.response.PersonUpdateResponse;

import java.util.Date;
import java.util.Optional;

public class PersonUpdateUseCase {

    private final PersonMock personMock;

    public PersonUpdateUseCase() {
        this.personMock = new PersonMock();
    }

    public PersonUpdateResponse updatePerson(PersonUpdateRequest personRequest) {
        Optional<Person> personToUpdate = this.personMock.getMockedPersons().stream().filter(person -> person.getId().equals(personRequest.getId())).findFirst();

        PersonUpdateResponse personUpdateResponse = null;
        if (personToUpdate.isPresent()) {
            personUpdateResponse = new PersonUpdateResponse();

            Person person = personToUpdate.get();

            this.personMock.getMockedPersons().remove(person);

            person.setName(personRequest.getName());
            person.setCpf(personRequest.getCpf());
            person.setName(personRequest.getAge());
            person.setUpdatedAt(new Date());
            this.personMock.getMockedPersons().add(person);

            personUpdateResponse.setId(person.getId());
            personUpdateResponse.setName(person.getName());
            personUpdateResponse.setCpf(person.getCpf());
            personUpdateResponse.setAge(person.getAge());
            personUpdateResponse.setUpdatedAt(person.getUpdatedAt());
            personUpdateResponse.setUpdatedAt(person.getCreatedAt());
        }

        return personUpdateResponse;
    }

}
