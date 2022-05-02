package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class RCVisTupleUser {
    UUID userid;
    RCVisTuple rcVisTuple;

    public UUID getUserid() {
        return userid;
    }

    public void setUserid(UUID userid) {
        this.userid = userid;
    }

    public RCVisTuple getRcVisTuple() {
        return rcVisTuple;
    }

    public void setRcVisTuple(RCVisTuple rcVisTuple) {
        this.rcVisTuple = rcVisTuple;
    }

    public RCVisTupleUser(@JsonProperty("userid")  UUID userid, @JsonProperty("rcVisTuple")  RCVisTuple rcVisTuple) {
        this.userid = userid;
        this.rcVisTuple = rcVisTuple;
    }
}
