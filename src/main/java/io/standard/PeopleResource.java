package io.standard;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import io.smallrye.mutiny.Uni;
import io.standard.models.People;
import io.standard.repositories.PeopleRepository;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/people")
public class PeopleResource {

    @RestClient
    private PeopleRepository peopleRepository;

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<People> fetchPeopleWithId(@PathParam("id") String id) {
        return this.peopleRepository.fetchPeopleById(id);
    }

}
