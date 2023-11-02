package org.example.person.service;

import org.example.base.CrudService;
import org.example.person.model.Person;
import org.example.person.request.PersonUpdateRequest;
import org.example.person.response.PersonUpdateResponse;

import java.util.Date;

public class PersonUpdateUseCase {

    private final CrudService crudService;

    public PersonUpdateUseCase() {
        this.crudService = new CrudService();
    }

    public PersonUpdateResponse updatePerson(PersonUpdateRequest personRequest) {

        PersonUpdateResponse personUpdateResponse = new PersonUpdateResponse();

        Person person = this.crudService.find(Person.class, personRequest.getId());
        if (person != null) {
            person.setName(personRequest.getName());
            person.setCpf(personRequest.getCpf());
            person.setAge(personRequest.getAge());
            person.setUpdatedAt(new Date());

            person = this.crudService.save(person);

            personUpdateResponse.setName(person.getName());
            personUpdateResponse.setCpf(person.getCpf());
            personUpdateResponse.setAge(person.getAge());
            personUpdateResponse.setUpdatedAt(person.getUpdatedAt());
            personUpdateResponse.setUpdatedAt(person.getCreatedAt());
        }

        return personUpdateResponse;
    }

}
