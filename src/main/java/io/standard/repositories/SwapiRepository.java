package io.standard.repositories;

import org.springframework.cache.annotation.Cacheable;

import io.standard.models.People;
import io.standard.models.Planet;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/api")
public interface SwapiRepository {

    @GET
    @Path("/people/{id}")
    @Produces({ MediaType.APPLICATION_JSON })
    @Cacheable
    People fetchPeopleById(@PathParam("id") Integer id);

    @GET
    @Path("/planets/{id}")
    @Produces({ MediaType.APPLICATION_JSON })
    @Cacheable
    Planet fetchPlanetById(@PathParam("id") Integer id);

}
