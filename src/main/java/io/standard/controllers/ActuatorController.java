package io.standard.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.HealthEndpoint;
import org.springframework.boot.actuate.metrics.MetricsEndpoint;
import org.springframework.stereotype.Component;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/actuator")
@Produces({ MediaType.APPLICATION_JSON })
@Component
public class ActuatorController {

    @Autowired
    private HealthEndpoint health;

    @Autowired
    private MetricsEndpoint metrics;

    @GET
    @Path("/health")
    public Object getHealth() {
        return health.health();
    }

    @GET
    @Path("/metrics")
    public Object getMetrics() {
        return this.metrics.listNames();
    }

    @GET
    @Path("/metrics/{name:.*}")
    public Object getMetric(@PathParam("name") final String name) {
        final Object value = this.metrics.metric(name, List.of());
        if (value == null) {
            throw new NotFoundException("No such metric: " + name);
        }
        return value;
    }

}
