package org.example.person.service;

import org.example.person.mock.PersonMock;
import org.example.person.model.Person;
import org.example.person.request.PersonDeleteRequest;
import org.example.person.response.PersonDeleteResponse;

import java.util.Optional;

public class PersonDeleteUseCase {

    private final PersonMock personMock;

    public PersonDeleteUseCase() {
        this.personMock = new PersonMock();
    }

    public PersonDeleteResponse deletePerson(int id) {
        Optional<Person> personToDelete = this.personMock.getMockedPersons().stream().filter(person -> person.getId().equals(id)).findFirst();

        PersonDeleteResponse personDeleteResponse = null;
        if (personToDelete.isPresent()) {
            personDeleteResponse = new PersonDeleteResponse();

            Person person = personToDelete.get();

            this.personMock.getMockedPersons().remove(person);

            personDeleteResponse.setId(person.getId());
            personDeleteResponse.setMessage("Deleted Succesfuly");
            return personDeleteResponse;
        }

        return personDeleteResponse;
    }

}
