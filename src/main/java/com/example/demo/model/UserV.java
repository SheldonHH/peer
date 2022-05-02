package com.example.demo.model;

import java.util.UUID;

public class UserV {
    public UUID id;
    public long[] vi;
    public boolean verified;

    public UserV(UUID id, long[] vi, boolean verified) {
        this.id = id;
        this.vi = vi;
        this.verified = verified;
    }
}
