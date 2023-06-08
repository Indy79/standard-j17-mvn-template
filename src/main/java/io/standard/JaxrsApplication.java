package io.standard;

import java.util.Set;

import io.standard.controllers.ActuatorController;
import io.standard.controllers.PeopleController;
import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

@ApplicationPath("/")
public class JaxrsApplication extends Application {

    public JaxrsApplication() {

    }

    @Override
    public Set<Class<?>> getClasses() {
        return Set.of(PeopleController.class, ActuatorController.class);
    }

}
