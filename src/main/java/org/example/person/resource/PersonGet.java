package org.example.person.resource;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.person.response.PersonGetResponse;
import org.example.person.service.PersonGetUseCase;

import java.util.List;

@Path("/persons")
public class PersonGet {

    private final PersonGetUseCase personGetUseCase;

    public PersonGet() {
        this.personGetUseCase = new PersonGetUseCase();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPerson() {
        List<PersonGetResponse> personGetResponseList = this.personGetUseCase.getPerson();

        return Response.ok(personGetResponseList).build();
    }
}
