package com.velocity.gateway.routing;

import com.velocity.gateway.config.VelocityProperties;

@Component
public class RouteMatcher{
    private final VelocityProperties velocityProperties;

    public RouteMatcher(VelocityProperties properties) {
        this.properties = properties;
    }

    // route matching
    public Route findRoute(String path) {

        for (Route route : properties.getRoutes()) {
            if (route.getPath().equals(path)) {
                return route;
            }
        }
        return null;
    }

}