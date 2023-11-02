package org.example.person.service;

import org.example.base.CrudService;
import org.example.person.model.Person;
import org.example.person.request.PersonCreateRequest;
import org.example.person.response.PersonCreateResponse;

public class PersonCreateUseCase {

    private final CrudService crudService;

    public PersonCreateUseCase() {
        this.crudService = new CrudService();
    }

    public PersonCreateResponse createPerson(PersonCreateRequest personRequest) {
        Person person = createPerson(personRequest.getName(), personRequest.getCpf(), personRequest.getAge());
        person = crudService.save(person);

        PersonCreateResponse personCreateResponse = new PersonCreateResponse();
        personCreateResponse.setId(person.getId());
        personCreateResponse.setName(person.getName());
        personCreateResponse.setCpf(person.getCpf());
        personCreateResponse.setAge(person.getAge());
        personCreateResponse.setCreatedAt(person.getCreatedAt());

        return personCreateResponse;
    }

    public Person createPerson(String name, String cpf, String age) {
        Person person = new Person();
        person.setName(name);
        person.setCpf(cpf);
        person.setAge(age);

        return person;
    }
}
