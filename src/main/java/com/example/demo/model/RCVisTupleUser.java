package com.example.demo.model;

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

    public RCVisTupleUser(UUID userid, RCVisTuple rcVisTuple) {
        this.userid = userid;
        this.rcVisTuple = rcVisTuple;
    }
}
