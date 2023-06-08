package io.standard;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import io.smallrye.mutiny.Uni;
import io.standard.models.Planet;
import io.standard.repositories.PlanetRepository;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/planets")
public class PlanetResource {

    @RestClient
    PlanetRepository planetRepository;

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<Planet> fetchPlanetWithId(@PathParam("id") String id) {
        return planetRepository.fetchPlanetById(id);
    }

}
