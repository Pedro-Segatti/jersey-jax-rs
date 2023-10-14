package org.example.person.resource;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.person.model.Person;
import org.example.person.request.PersonDeleteRequest;

@Path("/persons")
public class PersonDelete {
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deletePerson(PersonDeleteRequest PersonDeleteRequest) {
        Person person = new Person();

        // Pegar do MOCK

        return Response.ok(person).build();
    }

}
