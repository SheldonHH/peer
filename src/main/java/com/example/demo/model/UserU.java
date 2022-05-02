package com.example.demo.model;

import java.util.UUID;

public class UserU {
    public UUID id;
    public long[] ui;
    public boolean verified;

    public UserU(UUID id, long[] ui, boolean verified) {
        this.id = id;
        this.ui = ui;
        this.verified = verified;
    }
}
