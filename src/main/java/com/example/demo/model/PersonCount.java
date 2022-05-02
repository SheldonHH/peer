package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

public class PersonCount {

    @NotBlank
    private final int count;
    private final UUID person_ID;

    public PersonCount(@JsonProperty("id") int count, @JsonProperty("name") UUID person_ID) {
        this.count = count;
        this.person_ID = person_ID;
    }

    public int getCount() {
        return count;
    }

    public UUID getPerson_ID() {
        return person_ID;
    }
}
// localhost:8080/api/v1/person

/*
* {
*   "name": "James Bond"
* }
* */

