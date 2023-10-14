package org.example.person.resource;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.person.model.Person;
import org.example.person.request.PersonGetRequest;
import org.example.person.service.PersonCreateUseCase;
import org.example.person.service.PersonGetUseCase;
import org.example.person.service.PersonUpdateUseCase;

@Path("/persons")
public class PersonGet {

    private final PersonGetUseCase personGetUseCase;
    public PersonGet() {
        this.personGetUseCase = new PersonGetUseCase();
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getPerson(PersonGetRequest personGetRequest) {
        Person person = new Person();

        // Pegar do MOCK

        return Response.ok(person).build();
    }
}
