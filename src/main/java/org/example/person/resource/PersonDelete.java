package org.example.person.resource;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.person.request.PersonDeleteRequest;
import org.example.person.response.PersonDeleteResponse;
import org.example.person.service.PersonDeleteUseCase;

@Path("/persons")
public class PersonDelete {

    private final PersonDeleteUseCase personDeleteUseCase;

    public PersonDelete() {
        this.personDeleteUseCase = new PersonDeleteUseCase();
    }

    @Path("{id}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public Response deletePerson(@PathParam("id") int id) {
        PersonDeleteResponse personDeleteResponse = this.personDeleteUseCase.deletePerson(id);

        if (personDeleteResponse == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        return Response.ok(personDeleteResponse).build();
    }
}
