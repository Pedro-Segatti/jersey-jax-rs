package org.example.person.service;

import org.example.base.CrudService;
import org.example.person.model.Person;
import org.example.person.response.PersonDeleteResponse;

public class PersonDeleteUseCase {

    private final CrudService crudService;

    public PersonDeleteUseCase() {
        this.crudService = new CrudService();
    }

    public PersonDeleteResponse deletePerson(int id) {
        PersonDeleteResponse personDeleteResponse = new PersonDeleteResponse();

        this.crudService.delete(Person.class, id);
        personDeleteResponse.setId(id);
        personDeleteResponse.setMessage("Deleted Succesfuly");

        return personDeleteResponse;
    }
}
