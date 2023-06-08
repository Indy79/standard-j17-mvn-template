package io.standard.repositories;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import io.quarkus.cache.CacheResult;
import io.smallrye.mutiny.Uni;
import io.standard.models.People;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/people")
@RegisterRestClient(configKey = "swapi")
public interface PeopleRepository {

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @CacheResult(cacheName = "people-cache")
    public Uni<People> fetchPeopleById(@PathParam("id") String id);

}
