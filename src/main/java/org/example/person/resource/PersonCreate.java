package org.example.person.resource;

import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.person.request.PersonCreateRequest;
import org.example.person.response.PersonCreateResponse;
import org.example.person.service.PersonCreateUseCase;

@Path("/persons")
public class PersonCreate {

    private final PersonCreateUseCase personCreateUseCase;

    public PersonCreate() {
        this.personCreateUseCase = new PersonCreateUseCase();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response createPerson(PersonCreateRequest personCreateRequest) {
        PersonCreateResponse creatredPerson = personCreateUseCase.createPerson(personCreateRequest);
        return Response.ok(creatredPerson).build();
    }
}
