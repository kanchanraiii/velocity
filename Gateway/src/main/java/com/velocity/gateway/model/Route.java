package com.velocity.gateway.model;

public class Route{

    private String path;
    private String target;

    // getters and setters 
    public String getPath() {
        return path;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public void setPath(String path) {
        this.path = path;
    }

}