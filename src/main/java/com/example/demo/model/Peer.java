package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

public class Peer {
    private final UUID id;

    @NotBlank
    private final String name;

    public Peer(@JsonProperty("id") UUID id, @JsonProperty("name") String name) {
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
// localhost:8081/api/v1/peer

/*
 * {
 *   "name": "James Bond"
 * }
 * */

