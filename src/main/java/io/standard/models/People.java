package io.standard.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class People {

    private String name;

    private String mass;

    public People() {
    }

    public People(String name, String mass) {
        this.name = name;
        this.mass = mass;
    }

    public String getMass() {
        return mass;
    }

    public void setMAss(String mass) {
        this.mass = mass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
