package io.standard.controllers;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;
import org.springframework.stereotype.Component;

import io.standard.models.People;
import io.standard.repositories.SwapiRepository;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.UriBuilder;

@Component
@Path("/people")
public class PeopleController {

    private final UriBuilder FULL_PATH = UriBuilder.fromPath("https://swapi.dev/");

    private final SwapiRepository repo;

    public PeopleController() {
        ResteasyClient client = (ResteasyClient) ClientBuilder.newClient();
        ResteasyWebTarget target = client.target(FULL_PATH);
        repo = target.proxy(SwapiRepository.class);
    }

    @GET
    @Path("/{id}")
    @Produces({ MediaType.APPLICATION_JSON })
    public People getPeopleById(@PathParam("id") Integer id) {
        return repo.fetchPeopleById(id);
    }

}
