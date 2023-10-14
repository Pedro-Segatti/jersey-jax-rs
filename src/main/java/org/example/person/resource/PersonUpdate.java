package org.example.person.resource;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.person.model.Person;
import org.example.person.request.PersonUpdateRequest;
import org.example.person.service.PersonUpdateUseCase;

@Path("/persons")
public class PersonUpdate {

    private final PersonUpdateUseCase personUpdateUseCase;

    public PersonUpdate() {
        this.personUpdateUseCase = new PersonUpdateUseCase();
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updatePerson(PersonUpdateRequest PersonUpdateRequest) {
        Person person = new Person();

        // Pegar do MOCK

        return Response.ok(person).build();
    }
}
