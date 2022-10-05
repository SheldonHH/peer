package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import java.util.UUID;
// count total number of row that is training device have
public class PersonCount {

    @NotBlank
    private final int count;
    private final UUID person_ID;
    private String batch_time;

    public PersonCount(@JsonProperty("count") int count, @JsonProperty("person_ID") UUID person_ID, @JsonProperty("batch_time")String batch_time) {
        this.count = count;
        this.person_ID = person_ID;
        this.batch_time = batch_time;
    }

    public String getBatch_time() {
        return batch_time;
    }

    public void setBatch_time(String batch_time) {
        this.batch_time = batch_time;
    }

    public int getCount() {
        return count;
    }

    public UUID getPerson_ID() {
        return person_ID;
    }
}
// localhost:8081/api/v1/person

/*
* {
*   "name": "James Bond"
* }
* */

