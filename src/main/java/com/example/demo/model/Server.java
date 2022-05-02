package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

public class Server {
    private final UUID id;

    @NotBlank
    private final String name;

    public Server(@JsonProperty("id") UUID id, @JsonProperty("name") String name) {
        this.id = id;
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
// localhost:8080/api/v1/person

/*
 * {
 *   "name": "James Bond"
 * }
 * */

